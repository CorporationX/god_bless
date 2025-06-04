package school.faang.bjs2_79204;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class User {

    private String name;
    private static final int MIN_AGE = 18;
    private String job;
    private String address;
    private int age;

    private static final Set<String> VALID_JOB = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must not be null or empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("age must be at least " + MIN_AGE);
        }
        if (!VALID_JOB.contains(job)) {
            throw new IllegalArgumentException("job is not valid. Valid options: " + VALID_JOB);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("address is not valid. Valid options: " + VALID_ADDRESSES);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}