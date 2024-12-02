package school.faang.task_43660;

import lombok.ToString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ToString
public class User {
    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    static final int ADULTHOOD = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        if (age < ADULTHOOD) {
            throw new IllegalArgumentException("Must be over" + ADULTHOOD + "years of age");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The place of work is indicated incorrectly");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address is incorrect");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
