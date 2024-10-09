package school.faang.BJS2_31758;

import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
public class User {

    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESS = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private static final  int MIN_AGE = 18;
    private int id;
    private String name;
    private int age;
    private Set<String> activities;
    private String job;
    private String address;

    public User(int id, String name, int age, Set<String> activities, String job, String address) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
        this.job = job;
        this.address = address;

        validate();
    }

    private void validate() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null");
        }

        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age cannot be less than" + MIN_AGE + ".");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job. Job must be one of " + VALID_JOBS);
        }

        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Invalid address. Addres must be one of " + VALID_ADDRESS);
        }
    }
}
