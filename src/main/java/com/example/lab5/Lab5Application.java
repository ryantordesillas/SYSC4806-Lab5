package com.example.lab5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab5Application {

    private static final Logger log = LoggerFactory.getLogger(com.example.lab5.Lab5Application.class);

    public static void main(String[] args) {
        SpringApplication.run(com.example.lab5.Lab5Application.class);
    }
    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repo) {
        return (args) -> {
            repo.save(new BuddyInfo("Ryan", "123-456-7890", "12 Address Rd"));
            repo.save(new BuddyInfo("John", "437-915-4531", "84 That Way"));
            repo.save(new BuddyInfo("Sammy", "468-157-4827", "48 Gold Drive"));


            // fetch all BuddyInfos
            log.info("Buddies found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddy : repo.findAll()) {
                log.info(buddy.getName() + " " + buddy.getNumber() + " " + buddy.getAddress());
            }
            log.info("");

            // fetch an buddy by ID
            BuddyInfo buddy = repo.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(buddy.getName() + " " + buddy.getNumber() + " " + buddy.getAddress());
            log.info("");

            // fetch buddies by name
            log.info("Customer found with findByName('John'):");
            log.info("--------------------------------------------");
            repo.findByName("John").forEach(john -> {
                log.info(john.getName() + " " + john.getNumber() + " " + john.getAddress());
            });
            log.info("");

            // fetch buddies by number
            log.info("Customer found with findByNumber('123-456-7890'):");
            log.info("--------------------------------------------");
            repo.findByNumber("123-456-7890").forEach(number -> {
                log.info(number.getName() + " " + number.getNumber() + " " + number.getAddress());
            });
            log.info("");

            // fetch buddies by address
            log.info("Customer found with findByAddress('84 That Way'):");
            log.info("--------------------------------------------");
            repo.findByAddress("84 That Way").forEach(address -> {
                log.info(address.getName() + " " + address.getNumber() + " " + address.getAddress());
            });
            log.info("");
        };
    }
}
