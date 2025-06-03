package school.faang.bjs2_79225_registration;

import java.util.Set;

public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (!Util.hasText(name)) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;

        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older.");
        }
        this.age = age;

        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job.");
        }
        this.job = job;

        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address.");
        }
        this.address = address;
    }
}
