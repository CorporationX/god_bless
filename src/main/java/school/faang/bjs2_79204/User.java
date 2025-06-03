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

    private int age;

    private String job;

    private String address;

    private static final Set<String> VALID_JOB = Set.of("Google", "Uber", "Amazon");

    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must not be null or empty");
        }

        if (age < 18) {
            throw new IllegalArgumentException("age is less than 18");
        }

        if (!VALID_JOB.contains(job)) {
            throw new IllegalArgumentException("job is not valid");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("address is not valid");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}