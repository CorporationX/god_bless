package school.faang.bjs2_85689;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public class User {
    public static final int MIN_AGE = 18;
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age cannot be less than " + MIN_AGE + ".");
        }
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Must work in " + VALID_JOBS + ". Received: " + job);
        }
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The residential address must be in " +
                    VALID_ADDRESSES + ". Received: " + address);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}