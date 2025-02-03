package school.faang.registeringusers;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (!name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        if (age >= 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age cannot be greater than 18.");
        }
        if (VALID_JOBS.contains(job)) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("Job is not valid.");
        }
        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Address is not valid.");
        }
    }
}
