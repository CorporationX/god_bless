package school.faang.task_43693;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, Integer age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        if (age == null) {
            throw new IllegalArgumentException("Age cannot be empty!");
        } else if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18!");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The job must be one of the following: " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address must be one of the following: " + VALID_ADDRESSES);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
