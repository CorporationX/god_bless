package school.faang;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if (age <= VALID_AGE) {
            throw new IllegalArgumentException("The age must not be less than " + VALID_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job" + job);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid job" + address);
        }
    }
}
