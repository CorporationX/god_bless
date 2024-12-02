package school.faang.task_43666;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class User {
    private static final List<String> VALID_JOBS =
            Arrays.asList("Google",
            "Uber",
            "Amazon");
    private static final List<String> VALID_ADDRESSES =
            Arrays.asList("London",
                    "New York",
                    "Amsterdam");
    private static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
