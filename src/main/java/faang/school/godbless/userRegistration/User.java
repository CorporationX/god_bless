package faang.school.godbless.userRegistration;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;


    public User(String name, int age, String job, String address) {
        validation(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validation(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can't be empty");
        } else if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age can't be lower 18");
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job. Must contain valid jobs");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address. Must contain valid addresses");
        }
    }
}
