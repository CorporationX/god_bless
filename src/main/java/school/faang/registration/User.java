package school.faang.registration;

import java.util.List;

public class User {

    private final String name;
    private final int age;
    private final String job;
    private final String address;
    private static final int MIN_AGE = 18;

    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");


    public User(String name, int age, String job, String address) {

        validateDataInput(name, age, job, address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateDataInput(String name, int age, String job, String address) {
        if (name == null || age == 0 || job == null || address == null) {
            throw new IllegalArgumentException("Data field must not be null or 0");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Empty name");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age must not be less than 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(String.format("Invalid job: %s. Valid jobs are: %s", job, VALID_JOBS));
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Wrong address");
        }
    }
}
