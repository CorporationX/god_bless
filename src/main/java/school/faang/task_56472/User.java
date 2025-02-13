package school.faang.task_56472;

import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));
    private static final int MINIMUM_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        nameValidation(name);
        ageValidation(age);
        jobValidation(job);
        addressValidation(address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void nameValidation(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank!");
        }
    }

    public void ageValidation(int age) {
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Age cannot be less than 18!");
        }
    }

    public void jobValidation(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job. Valid options are: Google, Uber, Amazon.");
        }
    }

    public void addressValidation(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address. Valid option are: London, New York, Amsterdam");
        }
    }
}
