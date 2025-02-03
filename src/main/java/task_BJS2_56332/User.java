package task_BJS2_56332;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;


    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The place of work is not correct");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The location of work is not correct");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
