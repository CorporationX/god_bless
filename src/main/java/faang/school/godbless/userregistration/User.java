package faang.school.godbless.userregistration;

import lombok.Data;

import java.util.Set;

@Data
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Incorrect name!");
        } else if (age < 18) {
            throw new IllegalArgumentException("You are under 18");
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job is incorrect");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is incorrect");
        } else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }
}