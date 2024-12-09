package school.faang.sprint1.task_bjs243739;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public class User {
    private static final int MIN_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private Integer age;
    private String job;
    private String address;

    public User(String name, Integer age, String job, String address) {
        this.name = validateName(name);
        this.age = validateAge(age);
        this.job = validateJob(job);
        this.address = validateAddress(address);
    }

    private static String validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        return name;
    }

    private static Integer validateAge(Integer age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException(String.format("The age should be higher: %d", MIN_AGE));
        }
        return age;
    }

    private static String validateJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(String.format("The job should be one of : %s", VALID_JOBS));
        }
        return job;
    }

    private static String validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(String.format("The address should be one of : %s", VALID_ADDRESSES));
        }
        return address;
    }

}
