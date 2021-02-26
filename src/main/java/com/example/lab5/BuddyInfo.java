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

    @Column(nullable = false)
    private String address;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public BuddyInfo() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    public BuddyInfo(String name, String number, String address){
        this.name = name;
        this.number = number;
        this.address = address;
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

    @Override
    public String toString() {
        return "BuddyInfo{" +
                "book=" + book +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }
}
