package school.faang.bjs2_68246;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Set;

@RequiredArgsConstructor
@ToString
public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of(
            "Google",
            "Uber",
            "Amazon"
    );
    public static final Set<String> VALID_ADDRESSES = Set.of(
            "London",
            "New York",
            "Amsterdam"
    );
    public static final Integer VALID_AGE = 18;

    protected User(String name, Integer age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid user name: %s".formatted(name));
        }

        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Invalid user age: %d".formatted(age));
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(
                "Invalid job: \"%s\". The job must be one of the following: %s"
                .formatted(job, String.join(", ", VALID_JOBS))
            );
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(
                "Invalid address: \"%s\". The address must be one of the following: %s"
                .formatted(address, String.join(", ", VALID_ADDRESSES))
            );
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
