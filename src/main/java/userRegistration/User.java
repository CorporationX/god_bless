package userRegistration;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Your age is under 18 years old");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job specified");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address specified");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;

    }
}
