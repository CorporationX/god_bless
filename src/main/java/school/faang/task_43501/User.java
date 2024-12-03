package school.faang.task_43501;


import lombok.Data;

import java.util.Set;

@Data
public class User {
    private static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (VALID_JOBS.contains(job)) {
            this.job = job;

        } else {
            throw new IllegalArgumentException("Invalid job.");
        }
        if (VALID_ADDRESS.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Invalid address.");
        }
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (age >= 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be >= 18.");
        }
    }
}
