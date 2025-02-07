package school.faang.task_56460;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name is empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age must be at least 18 years old");
        }
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("This place of work is missing");
        }
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("This address is not in the list.");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
