package school.faang.bjs2_85558;

import java.util.Set;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    private static final int MIN_AGE = 18;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        validate(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validate(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job: " + job);
        }
        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Invalid address: " + address);
        }
    }
}