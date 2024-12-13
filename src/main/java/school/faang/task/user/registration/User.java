package school.faang.task.user.registration;

import lombok.ToString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ToString
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESS = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("The user must be of legal age");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The place of work must be included in the set : " + VALID_JOBS);
        }
        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("The address must be contained in the set : " + VALID_ADDRESS);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
