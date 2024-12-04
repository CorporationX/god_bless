package school.faang.user_registration;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final int MIN_AGE = 18;
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = new HashSet<>(
            Set.of("Google", "Uber", "Amazon"));

    private static final Set<String> VALID_ADDRESSES = new HashSet<>(
            Set.of("Big street", "Middle street", "Small street"));

    User(String name, int age, String job, String address) {
        try {
            validateUser(name, age, job, address);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;

        System.out.println("User has been created");
    }

    private void validateUser(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("User has not been created. Name should not be empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("User has not been created. Age must not be less than " + MIN_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("User has not been created. Job must be from the list");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("User has not been created. Address must be from the list");
        }
    }
}
