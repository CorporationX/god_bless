package school.faang.userregistration;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_LEGAL_AGE = 18;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        if (age < MIN_LEGAL_AGE) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        this.age = age;
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job is not a valid job");
        }
        this.job = job;
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is not a valid address");
        }
        this.address = address;
    }
}
