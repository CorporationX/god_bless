package school.faang.registration;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class User {
    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age fewer 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job isn't valid");
        }
        if (VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address isn't valid");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
