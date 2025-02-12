package school.faang.userRegistration;

import java.util.Set;

public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    public User(String name, int age, String job, String address) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age must be " + MIN_AGE + " or older");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job " + job + ". Must be one of: " + VALID_JOBS);
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address. Must be one of: London, New York, Amsterdam");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getAddress() {
        return address;
    }
}
