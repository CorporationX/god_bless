package school.faang.bjs2_68238;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;
    private static final int MIN_AGE = 18;

    private static final Set<String> VALID_JOBS =
            Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES =
            Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null || job == null || address == null) {
            throw new IllegalArgumentException("params is empty");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("name is empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("age unger " + 18);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("incorrect job");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("incorrect address");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
