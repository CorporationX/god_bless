package school.faang.constructorvalidation;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        validateCreationParameters(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateCreationParameters(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name could not be blank");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age could not be below 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job should be one of permitted list");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address should be one of permitted list");
        }
    }
}