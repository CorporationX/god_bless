package Validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static final Set<String> VALID_JOBS = new HashSet<>(
            List.of("Google", "Uber", "Amazon"));
    private static final Set<String> VAlID_ADDRESSES = new HashSet<>(
            List.of("London", "New York", "Amsterdam")
    );

    public User(String name, int age, String job, String address) {
        try {
            if (name.isBlank()) {
                throw new IllegalArgumentException("Error! Name cannot be empty");
            } else if (age < 18) {
                throw new IllegalArgumentException("Error! Age cannot be less than 18");
            } else if (!VALID_JOBS.contains(job)) {
                throw new IllegalArgumentException("Error! Job is not valid");
            } else if (!VAlID_ADDRESSES.contains(address)) {
                throw new IllegalArgumentException("Error! Address is not valid");
            } else {
                this.name = name;
                this.age = age;
                this.job = job;
                this.address = address;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("User: name: %s, age: %d, job: %s, address: %s", name, age, job, address);
    }
}
