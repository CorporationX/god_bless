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
        if (name.isBlank()) {
            throw new IllegalArgumentException("Wrong name!");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Wrong age!");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Wrong job!");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Wrong address!");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
