package school.faang;

import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString
@Getter
@NonNull
public class User {

    private static final int MIN_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty: " + name);
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age cannot be less than 18: " + age);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job: " + job);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address: " + address);
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
