package school.faang.bjs2_56348;

import lombok.Data;


//import java.util.Set;

import java.util.Set;
import static java.util.Set.of;

@Data
public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    private static final Set<String> VALID_JOBS = of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job must be one of: Google, Uber, Amazon");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address must be one of: London, New York, Amsterdam");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

}
