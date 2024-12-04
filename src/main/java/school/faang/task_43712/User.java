package school.faang.task_43712;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {

    private static final int MINIMUM_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
    }

    private void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty or contain spaces!");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("User age cannot be less " + MINIMUM_AGE + "!");
        }
        this.age = age;
    }

    private void setJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid Work Location. Available Options: " + VALID_JOBS);
        }
        this.job = job;
    }

    private void setAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address. Available options: " + VALID_ADDRESSES);
        }
        this.address = address;
    }
}