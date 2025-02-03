package school.faang.task_56341;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cant be empty");
        } else if (age < 18) {
            throw new IllegalArgumentException("The age must not be less than 18");
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The place of work must be included in the VALID_JOBS set.");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address must be contained in the VALID_ADDRESSES set.");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
