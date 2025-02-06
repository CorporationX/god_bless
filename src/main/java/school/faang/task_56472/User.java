package school.faang.task_56472;

import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
public class User {
    private static final Set<String> VALID_JOB;
    private static final Set<String> VALID_ADDRESSES;

    private String name;
    private int age;
    private String job;
    private String address;

    static {
        VALID_JOB = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
        VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));
    }

    public User(String name, int age, String job, String address) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank!");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less 18!");
        }
        this.age = age;
    }

    public void setJob(String job) {
        if (VALID_JOB.contains(job)) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("Invalid value of job!");
        }
    }

    public void setAddress(String address) {
        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Invalid value of address!");
        }
    }
}
