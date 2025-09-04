package school.faang.java_core.bjs2_85481;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final int VALID_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of(new String[]{"Google", "Uber", "Amazon"});
    private static final Set<String> VALID_ADDRESSES = Set.of(new String[]{"London", "New York", "Amsterdam"});

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("User age cannot be less than " + VALID_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The job description should include: " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address description should include: " + VALID_ADDRESSES);
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
