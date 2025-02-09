package school.faang.userRegistration;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(@NonNull String name, int age, @NonNull String job, @NonNull String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Your age is under 18 years old");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job. Available options: " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address specified");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;

    }
}
