package school.faang.BJS2_68162;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class User {
    private static final String[] VALID_JOBS = {"Google", "Uber", "Amazon"};
    private static final String[] VALID_ADDRESSES = {"London", "New York", "Amsterdam"};
    private static final int MIN_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (!isValid(name, age, job, address)) {
            throw new IllegalArgumentException("Invalid user values");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private static boolean isValid(String name, int age, String job, String address) {
        return name == null || name.isEmpty()
               || age < MIN_AGE
               || isValidJob(job)
               || isValidAddress(address);
    }

    private static boolean isValidAddress(String address) {
        return address == null || address.isEmpty() || Arrays.asList(VALID_ADDRESSES).contains(address);
    }

    private static boolean isValidJob(String job) {
        return job == null || job.isEmpty() || Arrays.asList(VALID_JOBS).contains(job);
    }
}
