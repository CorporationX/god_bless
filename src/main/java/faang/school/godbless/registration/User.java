package faang.school.godbless.registration;

import lombok.ToString;

import java.util.*;

@ToString
public class User {
    private static final Set<String> VALID_JOBS =
            new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES =
            new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private static final int MIN_AGE = 18;
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        condition(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void condition(String name, int age, String job, String address) {
        if (name.isEmpty() || name == null) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age must be at least 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job is not valid");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is not valid");
        }
    }

    public int getAge() {
        return age;
    }
}
