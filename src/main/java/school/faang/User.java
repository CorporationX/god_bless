package school.faang;

import java.util.Set;

public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name is empty");
        }
    }

    private void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address. Valid options are: London, New York, Amsterdam");
        }
    }

    private void validateJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job. Valid options are: Google, Uber, Amazon");
        }
    }

    private void validateAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age can't be less than 18");
        }
    }

    public User(String name, int age, String job, String address) {
        if (name == null || job == null || address == null) {
            throw new IllegalArgumentException("Name, job, and address can't be null");
        }
        validateName(name);
        validateAge(age);
        validateJob(job);
        validateAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
