package faang.school.godbless.BJS2_5192;

import java.util.Set;

import lombok.Data;

@Data
public class User {
    private static final int MIN_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validate(name, age, job, address);
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
    }

    public void validate(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The username cannot be blank. Please enter a correct name!");
        } else if (age < MIN_AGE) {
            throw new IllegalArgumentException("The user's age must be above " + MIN_AGE);
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Please provide the correct company name: 'Google', 'Uber', or 'Amazon'!");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Please provide the correct company address: 'London', 'New York', or 'Amsterdam'!");
        }
    }
}
