package school.faang.usersregistration;

import static java.util.Set.of;
import java.util.Set;

public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;
    static final Set<String> VALID_JOBS = of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = of("London", "New York", "Amsterdam");
    static final int MINIMUM_AGE = 18;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Age must be over 18");
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job must be one of: Google, Uber, Amazon");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address must be one of: London, New York, Amsterdam");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
