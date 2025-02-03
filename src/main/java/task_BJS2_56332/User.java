package task_BJS2_56332;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_LEGAL_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;


    public User(@NonNull String name, int age, @NonNull String job, @NonNull String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if (age < MIN_LEGAL_AGE) {
            throw new IllegalArgumentException(("Age cannot be less than %d").formatted(MIN_LEGAL_AGE));
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(("Job '%s' is not " +
                    "in the list of valid jobs: %s").formatted(job, VALID_JOBS));
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(("The location of work '%s' is not " +
                    "in the list of valid addresses: %s").formatted(address, VALID_ADDRESSES));
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
