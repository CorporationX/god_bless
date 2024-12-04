package school.faang.task_43732;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@Setter
public class User {
    public static final Set<String> VALID_JOBS = new HashSet<>();
    public static final Set<String> VALID_ADDRESSES = new HashSet<>();

    private String name;
    private Integer age;
    private String job;
    private String address;

    static {
        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");

        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");
    }

    public User(String name, Integer age, String job, String address) {
        nameValidation(name);
        ageValidation(age);
        jobValidation(job);
        addressValidation(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private static void nameValidation(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
    }

    private static void ageValidation(Integer age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
    }

    private static void jobValidation(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job");
        }
    }

    private static void addressValidation(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
    }
}