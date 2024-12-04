package school.faang.task_43690;

import java.util.List;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("This work is not on the list of allowed");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address is not listed in the allowed list");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
