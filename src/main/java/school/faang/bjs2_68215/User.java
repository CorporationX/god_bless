package school.faang.bjs2_68215;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Getter
@Setter
public class User {

    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 99;

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
            log.error("Invalid name provided: {}", name + " It must not be null or empty.");
            throw new IllegalArgumentException("Invalid name");
        }
    }

    private void validateAge(int age) {
        if (age < MIN_AGE || age > MAX_AGE) {
            log.error("Invalid age provided: {}", age + " It must be between " + MIN_AGE + " and " + MAX_AGE + ".");
            throw new IllegalArgumentException("Invalid age");
        }
    }

    private void validateJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            log.error("Invalid job provided: {}", job + " It must be one of the following: " + VALID_JOBS);
            throw new IllegalArgumentException("Invalid job");
        }
    }

    private void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            log.error("Invalid address provided: {}", address + " It must be one of the following: " + VALID_ADDRESSES);
            throw new IllegalArgumentException("Invalid address");
        }
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', age=%d, job='%s', address='%s'}", name, age, job, address);
    }
}
