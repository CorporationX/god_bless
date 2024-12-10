package school.faang.task_43742;

import java.util.Set;

public class User {
    private static final int MINIMUM_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        userValidation(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
    private void userValidation(String name, int age, String job, String address){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Your age must be at least 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Not a valid job");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Please enter a valid address");
        }
    }

}