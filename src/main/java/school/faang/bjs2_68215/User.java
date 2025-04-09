package school.faang.bjs2_68215;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import lombok.ToString;

import java.util.Set;

@Slf4j
@Getter
@Setter
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        validateName(name);
        this.name = name;
        validateAge(age);
        this.age = age;
        validateJob(job);
        this.job = job;
        validateAddress(address);
        this.address = address;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            log.error("Invalid name provided: {}  It must not be null or empty.", name);
            throw new IllegalArgumentException("Invalid name");
        }
    }

    private void validateAge(int age) {
        if (age < MIN_AGE) {
            log.error("Invalid age provided: {} It must be at least {}.", age, MIN_AGE);
            throw new IllegalArgumentException("Invalid age");
        }
    }

    private void validateJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            log.error("Invalid job provided: {} It must be one of the following: {}", job, VALID_JOBS);
            throw new IllegalArgumentException("Invalid job");
        }
    }

    private void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            log.error("Invalid address provided: {} It must be one of the following: {}", address, VALID_ADDRESSES);
            throw new IllegalArgumentException("Invalid address");
        }
    }
}