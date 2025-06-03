package school.faang.userValidation;

import lombok.ToString;
import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int PERMISSIBLE_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;


    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty");
        }

        if (age < PERMISSIBLE_AGE) {
            throw new IllegalArgumentException("min age is 18");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("this job is not in the list");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("this address is not in the list");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
