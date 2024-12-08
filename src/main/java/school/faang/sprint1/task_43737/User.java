package school.faang.sprint1.task_43737;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;
    private final String NAME_MESSAGE = "Name can not be empty.";
    private final String AGE_MESSAGE = "Age can not be less than 18.";



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
            throw new IllegalArgumentException(NAME_MESSAGE);
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException(AGE_MESSAGE);
        }
        this.age = age;
    }

    public void setJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job: " + job + ". Please provide a valid job.");
        }
        this.job = job;
    }

    public void setAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address: " + address + ". Please provide a valid address.");
        }
        this.address = address;
    }
}
