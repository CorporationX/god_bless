package school.faang.task_43501;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
@EqualsAndHashCode
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (VALID_JOBS.contains(job)) {
            this.job = job;

        } else {
            throw new IllegalArgumentException("Invalid job.");
        }
        if (VALID_ADDRESS.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Invalid address.");
        }
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (age >= 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be >= 18.");
        }
    }
}
