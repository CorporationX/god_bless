package school.faang;

import lombok.Data;
import java.util.Set;

@Data
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");

    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private static final int VALID_AGE = 18;

    private String name;

    private int age;

    private String job;

    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Age must be at least " + VALID_AGE);
        }
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job");
        }
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
