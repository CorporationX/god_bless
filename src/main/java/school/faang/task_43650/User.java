package school.faang.task_43650;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class User {
    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");
    private static final int MINIMUM_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        validateParams(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private static void validateParams(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        }
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Age fewer 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job isn't valid");
        }
        if (VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address isn't valid");
        }
    }
}
