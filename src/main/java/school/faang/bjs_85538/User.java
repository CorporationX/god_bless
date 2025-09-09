package school.faang.bjs_85538;

import java.util.Set;

public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

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
        if (this.name == null || this.name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void validateAge(int age) {
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Age must be 18 and over");
        }
    }

    private void validateJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job");
        }
    }

    private void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
    }
}
