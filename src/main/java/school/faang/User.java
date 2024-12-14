package school.faang;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static Set<String> VALID_JOBS;
    private static Set<String> VALID_ADDRESSES;
    private static final int MIN_AGE = 18;

    static {
        VALID_JOBS = Set.of("Google", "Uber", "Amazon");
        VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    }

    public User(String name, int age, String job, String address) {
        validate(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validate(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("age less than " + MIN_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("job is not valid");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("address is not valid");
        }
    }
}
