package faang.school.godbless.registration;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class User {

    public static final int USER_AGE_18 = 18;
    private String name;
    private Integer age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = new HashSet<>(List.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(List.of("London", "New York", "Amsterdam"));

    public User(String name, Integer age, String job, String address) {
        this.validate(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validate(String name, Integer age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Error: name is null or empty");
        }
        if (age < USER_AGE_18) {
            throw new IllegalArgumentException("Error: age is less than 18");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Error: address is not valid");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Error: job is not valid");
        }
    }
}
