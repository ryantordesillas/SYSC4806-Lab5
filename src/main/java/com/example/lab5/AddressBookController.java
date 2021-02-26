package com.example.lab5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AddressBookController {

    private AddressBookRepository repo;
    private BuddyInfoRepository buddy_repo;

    public AddressBookController(AddressBookRepository repo, BuddyInfoRepository buddy_repo) {
        this.repo = repo;
        this.buddy_repo = buddy_repo;
    }

    @GetMapping("/address-book")
    public String addressBook(@RequestParam(name = "id", required = true) String id, Model model){
        System.out.println("id = "+ id);
        Optional<AddressBook> repo_ab = repo.findById(Long.parseLong(id));
        if(repo_ab.isPresent()){
            AddressBook ab = repo_ab.get();
            model.addAttribute("addressBook",ab);
            model.addAttribute("buddyList",ab.getList());
            model.addAttribute("id",id);
            return "address-book";
        }
        return "address-book-error";
    }

    @GetMapping("/create-address-book")
    public String createAddressBook(Model model){
        // First Create a AddressBook and add it to the repo
        AddressBook ab = new AddressBook();
        repo.save(ab);
        model.addAttribute("ab_id", ab.getId());
        return "address-book-created";
    }

    @GetMapping("/create-buddy")
    public String createBuddy(@RequestParam(name = "id", required = true) String id, Model model){
        Optional<AddressBook> repo_ab = repo.findById(Long.parseLong(id));

        // Ensure that the repo is present
        if(repo_ab.isPresent()){

            // Create a new buddy that is linked to this addressBook
            model.addAttribute("buddy",new BuddyInfo());

            //add the id so the buddy is added to the correct AddressBook
            model.addAttribute("id",id);

            return "create-buddy";
        }
        return "address-book-error";
    }

    @PostMapping("/create-buddy-successful")
    public String buddySubmit(@RequestParam(name = "id", required = true) String id, @ModelAttribute BuddyInfo buddy, Model model){

        // In the last function it validated that the id was correct
        Optional<AddressBook> repo_ab = repo.findById(Long.parseLong(id));
        AddressBook ab = repo_ab.get();


        // Save the buddy in the buddy repo
        buddy_repo.save(buddy);

        //Add the buddy to the AddressBook and vice versa
        ab.addBuddy(buddy);
        buddy.setBook(ab);

        //Update the AddressBook to include the new book.
        repo.save(ab);

        // Add the buddy to the model for display
        model.addAttribute("buddy",buddy);

        // id will need to be added to create a link to add another buddy
        model.addAttribute("id",id);
        return "create-buddy-successful";
    }

    @GetMapping("/address-books")
    public String getAddressBooks(Model model){

        //Create a list of AddressBooks for the model
        List<AddressBook> ab_list = new ArrayList<AddressBook>();

        for (AddressBook ab: repo.findAll()){
            ab_list.add(ab);
        }
        model.addAttribute("list",ab_list);

        if(ab_list.isEmpty()){
            return "no-address-books";
        }
        return "address-books";
    }
}
