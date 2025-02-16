package school.faang;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int comingOfAge = 18;
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Enter your name!");
        }

        if (age < comingOfAge) {
            throw new IllegalArgumentException("You're too young!");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job is invalid!");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is invalid!");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("User {name = %s, age = %d, job = %s, address = %s}", name, age, job, address);
    }
}