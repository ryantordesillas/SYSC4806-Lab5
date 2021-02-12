package com.example.lab5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AddressBookController {
    private AddressBookRepository repo;

    public AddressBookController(AddressBookRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/address-book")
    public String addressBook(@RequestParam(name = "id", required = true) String id, Model model){
        System.out.println("id = "+ id);
        Optional<AddressBook> repo_ab = repo.findById(Long.parseLong(id));
        if(repo_ab.isPresent()){
            AddressBook ab = repo_ab.get();
            model.addAttribute("addressBook",ab);
            model.addAttribute("buddyList",ab.getList());
            return "address-book";
        }
        return "address-book-error";
    }

}
