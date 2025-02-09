package faang.school.task_56544;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    private static final int VALID_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        dataValidation(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void dataValidation(@NonNull String name, int age, @NonNull String job,
                                @NonNull String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Age cannot be less than 18.");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job must be from the VALID_JOBS set.");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address must be from the VALID_ADDRESSES set.");
        }
    }
}
