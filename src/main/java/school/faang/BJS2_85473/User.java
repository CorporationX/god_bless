package school.faang.BJS2_85473;

import java.util.Set;

public class User {
    String name;
    int age;
    String job;
    String address;

    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name should not be empty");
        } else if (age < 18) {
            throw new IllegalArgumentException("Age should be grater than 18");
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job is not valid");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is not valid");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
