package school.faang.bjs2_69338.model;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (!validateName(name)) {
            throw new IllegalArgumentException("Name could not be blank");
        }
        if (!validateAge(age)) {
            throw new IllegalArgumentException("Age could not be below 18");
        }
        if (!validateJob(job)) {
            throw new IllegalArgumentException("Job should be one of permitted list");
        }
        if (!validateAddress(address)) {
            throw new IllegalArgumentException("Address should be one of permitted list");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private boolean validateName(String name) {
        return !name.isBlank();
    }

    private boolean validateAge(int age) {
        return age >= 18;
    }

    private boolean validateJob(String job) {
        return VALID_JOBS.contains(job);
    }

    private boolean validateAddress(String address) {
        return VALID_ADDRESSES.contains(address);
    }
}