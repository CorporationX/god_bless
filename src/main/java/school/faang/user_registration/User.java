package school.faang.user_registration;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int LEGAL_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validateUser(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateUser(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        if (age < LEGAL_AGE) {
            throw new IllegalArgumentException("You must be over 18 years old!");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Your job is not on the list!");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Your address is not on the list!");
        }
    }
}