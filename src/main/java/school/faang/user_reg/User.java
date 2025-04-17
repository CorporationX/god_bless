package school.faang.user_reg;

import lombok.Getter;
import lombok.EqualsAndHashCode;

import java.util.List;

@Getter
@EqualsAndHashCode
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    public static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");
    public static final int VALID_AGE = 18;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Age must be >= " + VALID_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
