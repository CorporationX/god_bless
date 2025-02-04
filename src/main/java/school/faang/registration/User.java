package school.faang.registration;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        validateInputs(name, age, job, address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private static void validateInputs(String name, int age, String job, String address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age cannot be less than " + MIN_AGE);
        }
        if (job == null || job.trim().isEmpty()) {
            throw new IllegalArgumentException("Job is required");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid value for job: " + job);
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address is required");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid value for address: " + address);
        }
    }
}
