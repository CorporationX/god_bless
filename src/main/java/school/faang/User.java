package school.faang;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private static final int MINIMUM_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of(
            "Google",
            "Uber",
            "Amazon"
    );
    private static final Set<String> VALID_ADDRESSES = Set.of(
            "London",
            "New York",
            "Amsterdam"
    );

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty or blank");
        }
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Age must be at least 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job: " + job);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address: " + address);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

}
