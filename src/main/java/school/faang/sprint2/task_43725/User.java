package school.faang.sprint2.task_43725;

import java.util.List;
import java.util.Set;

public class User {
    private int age;
    private String name;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private User(int age, String name, String address, String job) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("job not in set");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("address not in set");
        }
        this.age = age;
        this.name = name;
        this.address = address;
        this.job = job;
    }

    public static void main(String[] args) {
        new User(
                18,
                "rauan",
                "London",
                "Google"
        );
        new User(
                18,
                "John",
                "us",
                "office"
        );

    }
}