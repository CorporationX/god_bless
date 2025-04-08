package school.faang.bjs2_68208;

import lombok.Data;

import java.util.Objects;
import java.util.Set;

@Data
public class User {
    private static final int MINIMUM_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of(
            "Google",
            "Uber",
            "Amazon"
    );
    private static final Set<String> VALID_ADDRESSES = Set.of(
            "London",
            "New York",
            "Amsterdam"
    );

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validateName(name);
        validateAge(age);
        validateJob(job);
        validateAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("Field 'name' is not valid!");
        }
    }

    private void validateAge(int age) {
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Field 'age' is not valid!");
        }
    }

    private void validateJob(String job) {
        if (Objects.isNull(address) || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Field 'job' is not valid!");
        }
    }

    private void validateAddress(String address) {
        if (Objects.isNull(address) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Field 'address' is not valid!");
        }
    }
}
