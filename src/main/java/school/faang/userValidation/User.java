package school.faang.userValidation;

import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));
    private static final int permissibleAge = 18;

    private String name;
    private int age;
    private String job;
    private String address;


    public User(String name, int age, String job, String address) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("name cannot be empty");
        }

        if (age >= permissibleAge) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("min age is 18");
        }

        if (VALID_JOBS.contains(job)) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("this job is not in the list");
        }

        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("this address is not in the list");
        }
    }
}
