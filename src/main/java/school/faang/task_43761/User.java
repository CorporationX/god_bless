package school.faang.task_43761;

import lombok.Data;

import java.util.Set;

import static java.lang.Boolean.FALSE;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public static final String NAME_NOT_NULL = "Name cannot be null or empty";
    public static final String MIN_AGE_ERROR = "Age cannot be less than 18";
    public static final String INVALID_JOB = "Invalid job for: %s";
    public static final String INVALID_ADDRESS = "Invalid job for: %s";

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(NAME_NOT_NULL);
        }
        this.name = name;
        if (age < 18) {
            throw new IllegalArgumentException(MIN_AGE_ERROR);
        }
        this.age = age;

        if (FALSE.equals(VALID_JOBS.contains(job))) {
            throw new IllegalArgumentException(String.format(INVALID_JOB, job));
        }
        this.job = job;

        if (FALSE.equals(VALID_ADDRESSES.contains(address))) {
            throw new IllegalArgumentException(String.format(INVALID_ADDRESS, address));
        }
        this.address = address;
    }
}
