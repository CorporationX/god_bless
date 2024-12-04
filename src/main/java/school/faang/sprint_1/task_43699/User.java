package school.faang.sprint_1.task_43699;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private static final int MAJORITY_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validateUser(name, age, job, address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateUser(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The user name cannot be empty");
        }
        if (age < MAJORITY_AGE) {
            throw new IllegalArgumentException("The user's age cannot be less than " + MAJORITY_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
    }
}
