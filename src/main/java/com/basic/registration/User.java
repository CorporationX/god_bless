package com.basic.registration;

import lombok.Data;
import lombok.ToString;

import java.util.Set;
@Data
@ToString
public class User {
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String jobs;
    private String address;

    public User(String name, int age, String jobs, String address) {
        if (age > 18 && !name.isEmpty() && VALID_JOBS.contains(jobs) && VALID_ADDRESSES.contains(address)) {
            this.age = age;
            this.name = name;
            this.jobs = jobs;
            this.address = address;
        } else {
            throw new IllegalArgumentException("Argument is not valid");
        }

    }


}
