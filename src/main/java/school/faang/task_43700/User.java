package school.faang.task_43700;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOB = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older");
        }

        if(!VALID_JOB.contains(job)) {
            throw new IllegalArgumentException("Invalid job='" + job + "'. Must be one of: " + VALID_JOB);
        }

        if(!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Invalid address='" + address + "'. Must be one of: " + VALID_ADDRESS);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User(name='" + name + "', age=" + age + ", job='" + job + "', address='" + address + "')";
    }
}
