package school.faang.bjs2_85527;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class User {

    private String name;
    private int age;
    private String job;
    private String address;

    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    static final int MIN_AGE = 18;

    public User(String name, int age, String job, String address) {

        validateUser(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateUser(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is empty or null");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age cannot be less than " + MIN_AGE);
        }
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job. Valid jobs: " + VALID_JOBS);
        }
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address. Valid addresses: " + VALID_ADDRESSES);
        }
    }
}