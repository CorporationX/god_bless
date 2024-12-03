package school.faang.sprint_1.task_bjs243706;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MINIMUM_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validateCredentials(name, age, job, address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateCredentials(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("name must be not blank");
        }

        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("age must be 18 and over");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("job must be in list of jobs");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("address must be in list of addresses");
        }
    }
}
