package school.faang.task_79260;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final int VALID_AGE = 18;
    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The place of work is not valid");
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
