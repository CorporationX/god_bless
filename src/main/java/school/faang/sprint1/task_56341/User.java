package school.faang.sprint1.task_56341;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String addres;
    private static final int MINIMUM_AGE = 18;
    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        this.name = validateName(name);
        this.age = validateAge(age);
        this.job = validateJob(job);
        this.addres = validateAddress(address);
    }

    private String validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cant be empty --> " + name);
        }
        return name;
    }

    private int validateAge(int age) {
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("The age must not be less than 18 --> " + age);
        }
        return age;
    }

    private String validateJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The place of work must be included in the VALID_JOBS set --> " + job);
        }
        return job;
    }

    private String validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address must be contained in the" +
                    " VALID_ADDRESSES set --> " + address);
        }
        return address;
    }
}
