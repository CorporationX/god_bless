package school.faang.uservalidation;

import lombok.Data;

import java.util.Set;

@Data
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age must be at least 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job must be one of: " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address must be one of: " + VALID_ADDRESSES);
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
