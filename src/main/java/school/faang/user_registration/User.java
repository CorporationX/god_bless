package school.faang.user_registration;

import lombok.Data;

import java.util.Arrays;

@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final String[] VALID_JOBS = {"Google", "Uber", "Amazon"};
    private static final String[] VALID_ADDRESSES = {"London", "New York", "Amsterdam"};

    public User(String name, int age, String job, String address) throws IllegalArgumentException {
        if (!(name == null || name.isEmpty())) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (!(age < 18)) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }

        if (Arrays.asList(VALID_JOBS).contains(job)) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("IllegalArgument for job");
        }

        if (Arrays.asList(VALID_ADDRESSES).contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("IllegalArgument for address");
        }
    }
}
