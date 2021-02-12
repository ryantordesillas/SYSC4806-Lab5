package com.example.lab5;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BuddyInfo{

    @ManyToOne
    @JoinColumn(name = "ab_id")
    private AddressBook book;

    // The name of the Buddy
    @Column(nullable = false)
    private String name;

    // The phone number of the Buddy
    @Column(nullable = false)
    private String number;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public BuddyInfo() {

    }

    public AddressBook getBook() {
        return book;
    }

    public void setBook(AddressBook book) {
        this.book = book;
    }

    /**
     * Constructor of the com.example.accessingdatajpa.BuddyInfo object
     * @param name the name of the Buddy
     * @param number the number of the Buddy
     */
    public BuddyInfo(String name, String number){
        this.name = name;
        this.number = number;
    }

    /**
     * Gets the name of the Buddy
     * @return the name of the Buddy
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Buddy
     * @param name the name of the Buddy
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the phone number of the Buddy
     * @return the phone number of the Buddy
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the phone number of the Buddy
     * @param number the phone number of the Buddy
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Get the id of this com.example.accessingdatajpa.BuddyInfo object
     */
    public long getId() {
        return this.id;
    }

    /**
     * Sets the id of the com.example.accessingdatajpa.BuddyInfo object.
     * @param id the new id for this com.example.accessingdatajpa.BuddyInfo object.
     */
    public void setId(long id) {
        this.id = id;
    }
}
