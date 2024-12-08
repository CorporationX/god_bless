package school.faang.s12task43705;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {

    private String name;
    private int age;
    private String job;
    private String address;
    private static final int MIN_AGE = 18;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("The name not set");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("The age cannot be less then " + MIN_AGE);
        }
        this.age = age;
    }

    public void setJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The job should be valid");
        }
        this.job = job;
    }

    public void setAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address should be valid");
        }
        this.address = address;
    }
}