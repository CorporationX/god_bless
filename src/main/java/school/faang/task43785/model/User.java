package school.faang.task43785.model;

import lombok.Data;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Data
public class User {

    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        StringBuilder errorText = new StringBuilder();

        if (name == null || name.isEmpty()) {
            errorText.append("User's name can't be empty! Current value :").append(name).append("\n");
        }

        if (age < 18) {
            errorText.append("User's Age can't be < 18! Current value: ").append(age).append("\n");
        }

        if (!VALID_JOBS.contains(job)) {
            errorText.append("User's job must be in list: ").append(VALID_JOBS).append(". Current value: ").append(job).append("\n");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            errorText.append("User's address must be in list: ").append(VALID_ADDRESSES).append(". Current value: ").append(address).append("\n");
        }

        if (!errorText.isEmpty()) {
            throw new IllegalArgumentException(String.valueOf(errorText));
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
