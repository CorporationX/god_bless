package school.faang.bjs2_79200;

import java.util.Set;

public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int MIN_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age under " + MIN_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job. Should be " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address. Should be " + VALID_ADDRESSES);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
