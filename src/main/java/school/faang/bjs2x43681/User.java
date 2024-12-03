package school.faang.bjs2x43681;

import java.util.Set;

import lombok.Getter;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        this.name = checkName(name);
        this.age = checkAge(age);
        this.job = checkJob(job);
        this.address = checkAddress(address);
    }

    private String checkName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name value mustn't be empty");
        } else {
            return name;
        }
    }

    private int checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age mustn't be less 18");
        } else {
            return age;
        }
    }

    private String checkJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid place of job");
        } else {
            return job;
        }
    }

    private String checkAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        } else {
            return address;
        }
    }
}
