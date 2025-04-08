package school.faang.reg_users;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int ALLOWED_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;

        if (age < ALLOWED_AGE) {
            throw new IllegalArgumentException("Age cannot be less than " + ALLOWED_AGE);
        }
        this.age = age;

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job");
        }
        this.job = job;

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
