package faang.school.godbless;

import lombok.*;
import java.util.*;

@Data
public class User {
    public static final int MIN_AGE = 18;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String id;
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String id, String name, int age, String job, String address) {
        validateParameters(id, name, age, job, address);

        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateParameters(String id, String name, int age, String job, String address) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id cannot be null or empty");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("age cannot be less than " + MIN_AGE);
        }
        if (job == null || job.isEmpty()) {
            throw new IllegalArgumentException("job cannot be null or empty");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("address cannot be null or empty");
        }
    }
}