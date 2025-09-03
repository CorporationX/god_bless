package school.faang.bjs2_85551;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is null or empty");
        }
        if (age <= 18) {
            throw new IllegalArgumentException("Age must not be younger than 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The place of work must be included in the set");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address must be included in the set");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
