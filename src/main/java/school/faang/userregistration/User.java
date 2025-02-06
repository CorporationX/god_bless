package school.faang.userregistration;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int ADULT = 18;

    public User(String name, int age, String job, String address) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        } else {
            this.name = name;
        }

        if (age < ADULT) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        } else {
            this.age = age;
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job is not a valid job");
        } else {
            this.job = job;
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is not a valid address");
        } else {
            this.address = address;
        }

    }

}
