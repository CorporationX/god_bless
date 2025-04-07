package school.faang.userregistration;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private static final int MIN_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The name is null or empty!");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException(String.format("The age is under %d!", MIN_AGE));
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The job is not valid!");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address is not valid!");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
