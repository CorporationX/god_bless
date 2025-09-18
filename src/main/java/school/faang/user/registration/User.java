package school.faang.user.registration;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private static final int MIN_AGE = 18;

    private final String name;
    private final Integer age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age less than " + MIN_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Not valid job");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Not valid address");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
