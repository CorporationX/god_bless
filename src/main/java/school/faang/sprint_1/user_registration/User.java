package school.faang.sprint_1.user_registration;

import lombok.Getter;

import java.util.List;

@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");
    private static final int AGE_OF_MAJORITY = 18;

    public User(String name, int age, String job, String address) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        } else {
            this.name = name;
        }

        if (age >= AGE_OF_MAJORITY) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }

        if (VALID_JOBS.contains(job)) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("IllegalArgument for job");
        }

        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("IllegalArgument for address");
        }
    }
}
