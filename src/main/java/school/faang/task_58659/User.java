package school.faang.task_58659;

import java.util.Arrays;
import java.util.List;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Empty name");
        }
        this.name = name;

        if (age < 18) {
            throw new IllegalArgumentException("Age is under 18");
        }
        this.age = age;

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job");
        }
        this.job = job;

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
        throw new IllegalArgumentException("Invalid address");
    }
}