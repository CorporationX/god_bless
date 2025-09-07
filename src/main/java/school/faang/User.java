package school.faang;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final String name;
    private final Integer age;
    private final String job;
    private final String address;

    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));

    public User(String name, Integer age, String job, String address) {
        this.name = this.nameValidation(name);
        this.age = this.ageValidation(age);
        this.job = this.jobValidation(job);
        this.address = this.addressValidation(address);
    }

    private String nameValidation(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        return name;
    }

    private Integer ageValidation(Integer age) {
        if (age == null || age < 18) {
            throw new IllegalArgumentException("User age must be 18 or older");
        }
        return age;
    }

    private String jobValidation(String job) {
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("User must work in one of these companies: " + VALID_JOBS);
        }
        return job;
    }

    private String addressValidation(String address) {
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("User must live in one of these places: " + VALID_ADDRESSES);
        }
        return address;
    }
}
