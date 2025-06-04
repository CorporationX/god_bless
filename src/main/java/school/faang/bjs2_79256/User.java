package school.faang.bjs2_79256;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int PASSING_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (age < PASSING_AGE) {
            throw new IllegalArgumentException();
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException();
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
