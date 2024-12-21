package derschrank.sprint01.task06.bjstwo_43684;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int PERMITTED_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validateAndSetName(name);
        validateAndSetAge(age);
        validateAndSetJob(job);
        validateAndSetAddress(address);
    }

    private void validateAndSetName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(("Name is null or blank, " + name));
        }
        this.name = name;
    }

    private void validateAndSetJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(("Job is not from the allowed set, " + job));
        }
        this.job = job;
    }

    private void validateAndSetAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is not from the allowed set, " + address);
        }
        this.address = address;
    }

    private void validateAndSetAge(int age) {
        if (age < PERMITTED_AGE) {
            throw new IllegalArgumentException("Age must be over 18, but is " + age);
        }
        this.age = age;
    }

    public String toString() {
        return String.format("User: %s (age %d), lives in %s, works at %s", name, age, address, job);
    }
}
