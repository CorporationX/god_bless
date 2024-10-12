package school.faang.bjs2_31867;

import lombok.ToString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    private String name;
    private Integer age;
    private String jobLocation;
    private String address;

    public User(String name, Integer age, String jobLocation, String address) {
        validateInputAllArgsConstructor(name, age, jobLocation, address);
        this.name = name;
        this.age = age;
        this.jobLocation = jobLocation;
        this.address = address;
    }

    private void validateInputAllArgsConstructor(String name, Integer age, String jobLocation, String address) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be empty");
        }
        int minAge = 18;
        if (age == null || age < minAge) {
            throw new IllegalArgumentException("age = " + age + " cannot be less than 18");
        }
        if (!(VALID_JOBS.contains(jobLocation))) {
            throw new IllegalArgumentException("job must be one of the valid job options");
        }
        if (!(VALID_ADDRESSES.contains(address))) {
            throw new IllegalArgumentException("address must be one of the valid addresses");
        }
    }
}
