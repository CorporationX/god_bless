package school.faang.task4;


import lombok.Getter;

import java.util.Set;

@Getter
public class User {

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York");

    private final String name;
    private final int age;
    private final String job;
    private final String address;


    public User(String name, int age, String job, String address) {
        validateName(name);
        validateAge(age);
        validateJob(job);
        validateAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
    }

    private void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18");
        }
    }

    private void validateJob(String job) {
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job must be one of: " + VALID_JOBS);
        }
    }

    private void validateAddress(String address) {
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address must be one of: " + VALID_ADDRESSES);
        }
    }
}
