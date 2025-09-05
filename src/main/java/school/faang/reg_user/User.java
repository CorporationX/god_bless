package school.faang.reg_user;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    static final int MINIMUM_USER_AGE = 18;

    private String name;
    private Integer age;
    private String job;
    private String address;

    public User(String name, Integer age, String job, String address) {
        validateUser(name, age, job, address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private static void validateUser(String name, Integer age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty");
        }

        if (age < MINIMUM_USER_AGE) {
            throw new IllegalArgumentException("age is under %s, actual value: %s".formatted(MINIMUM_USER_AGE, age));
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("job %s is not valid, permitted values: %s".formatted(job, VALID_JOBS));
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("address %s is not valid, permitted values: %s"
                    .formatted(address, VALID_ADDRESSES));
        }
    }
}
