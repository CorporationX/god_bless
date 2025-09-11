package school.faang.bjs2_85669;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class User {
    private static final int AGE_LIMIT = 18;
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");
    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (age < AGE_LIMIT) {
            throw new IllegalArgumentException("Age cannot be less than " + AGE_LIMIT);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Must work in " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The residential address must be in " +
                    VALID_ADDRESSES);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}