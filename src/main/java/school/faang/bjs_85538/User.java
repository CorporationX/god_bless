package school.faang.bjs_85538;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;

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

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void validateAge(int age) {
        if (age < VALID_AGE) {
            throw new IllegalArgumentException(String.format("Age must be %d and over", VALID_AGE));
        }
    }

    private void validateJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job");
        }
    }

    private void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
    }
}
