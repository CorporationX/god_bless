package school.faang.user_registration.BJS2_56387;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {

    private static final int MINIMUM_AGE = 18;
    private static final int MAXIMUM_LENGTH_NAME = 50;
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
        validateName(name);
        validateAge(age);
        validateJob(job);
        validateAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private static void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address: " + address);
        }
    }

    private static void validateJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job: " + job);
        }
    }

    private static void validateAge(int age) {
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Age must be at least " + MINIMUM_AGE);
        }
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > MAXIMUM_LENGTH_NAME) {
            throw new IllegalArgumentException(
                    "The name cannot be empty, blank or too long, received: " + name);
        }
    }

}
