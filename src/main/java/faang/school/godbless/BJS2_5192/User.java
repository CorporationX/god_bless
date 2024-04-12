package faang.school.godbless.BJS2_5192;

import java.util.Set;

import lombok.Data;

@Data
public class User {
    private static final int minAge = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The username cannot be blank. Please enter a correct name!");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < minAge) {
            throw new IllegalArgumentException("The user's age must be above " + minAge);
        }
        this.age = age;
    }

    public void setJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Please provide the correct company name: 'Google', 'Uber', or 'Amazon'!");
        }
        this.job = job;
    }

    public void setAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Please provide the correct company address: 'London', 'New York', or 'Amsterdam'!");
        }
        this.address = address;
    }

}
