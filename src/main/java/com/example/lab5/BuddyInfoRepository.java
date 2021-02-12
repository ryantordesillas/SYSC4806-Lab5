package com.example.lab5;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(String name);

    BuddyInfo findById(long id);

    List<BuddyInfo> findByNumber(String number);

    List<BuddyInfo> findByAddress(String address);
}
