package faang.school.godbless;

import lombok.*;

import java.util.*;

@Data
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final int AGE_FROM = 18;

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {

        checkValidName(name);
        checkValidAge(age);
        checkValidJobs(workPlace);
        checkValidAddresses(address);

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    private void checkValidName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name couldn't be empty");
        }
    }

    private void checkValidAge(int age) {
        if (age < AGE_FROM) {
            throw new IllegalArgumentException("Age couldn't be less than 18");
        }
    }

    private void checkValidJobs(String workPlace) {
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Job should be from [Amazon, Uber, Google]");
        }
    }

    private void checkValidAddresses(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address should be from [New York, London, Amsterdam]");
        }
    }
}