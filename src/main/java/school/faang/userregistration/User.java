package school.faang.userregistration;

import lombok.Data;
import lombok.Getter;
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

    public User(String name, int age, String job, String address) {
        checkArguments(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void checkArguments(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("The name cannot be empty!");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("The age must not be less than " + MIN_AGE + "\n"
                    + "The entered age value - " + age);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The place of work must be included in the set: " + VALID_JOBS + "\n"
                    + "The entered job value - " + job);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address must be included in the set: " + VALID_ADDRESSES + "\n"
                    + "The entered address value - " + address);
        }
    }
}
