package school.faang.BJS2_79296.model;

import lombok.Getter;
import java.util.*;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.trim().isEmpty()) {
            String errorMessage = "Name cannot be null or empty.";
            throw new IllegalArgumentException(errorMessage);
        }
        if (age < 18) {
            String errorMessage = "Age cannot be lower than 18.";
            throw new IllegalArgumentException(errorMessage);
        }
        if (!VALID_JOBS.contains(job)) {
            String errorMessage = String.format(
                    "Non-valid job was provided - %s. Please use one of the following: %s",
                    job,
                    String.join(", ", VALID_JOBS));
            throw new IllegalArgumentException(errorMessage);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            String errorMessage = String.format(
                    "Non-valid address was provided - %s. Please use one of the following: %s",
                    address,
                    String.join(", ", VALID_ADDRESSES));
            throw new IllegalArgumentException(errorMessage);
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}