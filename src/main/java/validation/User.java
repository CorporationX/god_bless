package validation;

import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;
    private static final int MINIMUM_AGE = 18;
    private static final Set<String> VALID_JOBS = new HashSet<>(
            Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(
            Set.of("London", "New York", "Amsterdam"));

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Error! Name cannot be empty");
        }

        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Error! Age cannot be less than 18");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Error! Job is not valid");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Error! Address is not valid");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("User: name: %s, age: %d, job: %s, address: %s", name, age, job, address);
    }
}
