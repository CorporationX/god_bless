package school.faang.reg_users;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class User {

    private final String name;
    private int age;
    private String job;
    private String address;

    public static final Set<String> VALID_JOBS = new HashSet<>(List.of("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(List.of("London", "New York", "Amsterdam"));
    public static final int VALID_AGE = 18;

    public User(String name, int age, String job, String address) {
        this.name = checkName(name);
        this.age = checkAge(age);
        this.job = checkJob(job);
        this.address = checkAddress(address);
    }

    private String checkName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        return name;
    }

    private int checkAge(int age) {
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        return age;
    }

    private String checkJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job: " + job);
        }
        return job;
    }

    private String checkAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address: " + address);
        }
        return address;
    }
}
