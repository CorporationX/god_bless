package school.faang.usersregistration;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    final int validAge = 18;

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (age < validAge) {
            throw new IllegalArgumentException("Age must be over 18");
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job is not valid");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is not valid");
        }
        this.age = age;
        this.job = job;
        this.name = name;
        this.address = address;
    }
}
