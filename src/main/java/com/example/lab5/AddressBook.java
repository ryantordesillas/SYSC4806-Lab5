package com.example.lab5;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    // The list of Buddies to be stored on the com.example.accessingdatajpa.AddressBook
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private List<BuddyInfo> list;

    @Id
    @GeneratedValue
    private long id;

    public List<BuddyInfo> getList() {
        return list;
    }

    public void setList(List<BuddyInfo> list) {
        this.list = list;
    }

    /**
     * Get the id of this com.example.accessingdatajpa.AddressBook
     */
    public long getId() {
        return this.id;
    }

    /**
     * Set the id of this com.example.accessingdatajpa.AddressBook
     * @param id the new id for this com.example.accessingdatajpa.AddressBook
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * Construct a com.example.accessingdatajpa.AddressBook by creating an ArrayList of com.example.accessingdatajpa.BuddyInfo objects
     */
    public AddressBook(){
        list = new ArrayList<BuddyInfo>();
    }

    /**
     * Add a com.example.accessingdatajpa.BuddyInfo object to the com.example.accessingdatajpa.AddressBook list
     * @param buddy the com.example.accessingdatajpa.BuddyInfo object to be added
     */
    public void addBuddy(BuddyInfo buddy){
        list.add(buddy);
    }

    /**
     * Remove a com.example.accessingdatajpa.BuddyInfo object from the com.example.accessingdatajpa.AddressBook
     * @param buddy the com.example.accessingdatajpa.BuddyInfo object to be removed
     * @return true if a buddy was successfully removed, false otherwise
     */
    public boolean removeBuddy(BuddyInfo buddy){
        // Find the a com.example.accessingdatajpa.BuddyInfo object with the given name and number
        int i = list.indexOf(buddy);
        if (i != -1){
            list.remove(i);
            return true;
        }
        return false;
    }

    /**
     * Get the com.example.accessingdatajpa.BuddyInfo at the given index
     * @param i the index of the wanted com.example.accessingdatajpa.BuddyInfo object
     * @return the com.example.accessingdatajpa.BuddyInfo Object
     */
    public BuddyInfo getBuddy(int i){
        if (i >= list.size() || i < 0){

            System.out.println("There is no com.example.accessingdatajpa.BuddyInfo at that index!");
            return null;
        }
        return list.get(i);
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "list=" + list +
                ", id=" + id +
                '}';
    }

    public int size() {
        return list.size();
    }

    // The main function to populate a address book
//    public static void main(String[] args){
//        // Create the main com.example.accessingdatajpa.AddressBook
//        com.example.accessingdatajpa.AddressBook ab = new com.example.accessingdatajpa.AddressBook();
//
//        // Create the com.example.accessingdatajpa.BuddyInfo objects to add to the com.example.accessingdatajpa.AddressBook
//        com.example.accessingdatajpa.BuddyInfo buddy1 = new com.example.accessingdatajpa.BuddyInfo("Ryan", "123-456-1234");
//        com.example.accessingdatajpa.BuddyInfo buddy2 = new com.example.accessingdatajpa.BuddyInfo("John", "753-678-6878");
//        com.example.accessingdatajpa.BuddyInfo buddy3 = new com.example.accessingdatajpa.BuddyInfo("Aaron", "671-318-6518");
//        com.example.accessingdatajpa.BuddyInfo buddy4 = new com.example.accessingdatajpa.BuddyInfo("Joshua", "642-658-9756");
//
//        // Add the com.example.accessingdatajpa.BuddyInfo objects into the com.example.accessingdatajpa.AddressBook
//        ab.addBuddy(buddy1);
//        ab.addBuddy(buddy2);
//        ab.addBuddy(buddy3);
//        ab.addBuddy(buddy4);
//    }


}
