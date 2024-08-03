package faang.school.godbless;

import lombok.*;

import java.util.*;

@Data
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name couldn't be empty");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Age couldn't be less than 18");
        }

        if(!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Job should be from [Amazon, Uber, Google]");
        }

        if(!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address should be from [New York, London, Amsterdam]");
        }

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }
}