package school.faang.bjs243653;

import lombok.Getter;

import java.util.Set;

@Getter

public class User {
    private static final int MIN_AGE = 18;
    private static final Set VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can not empty");
        }
    }

    public void setAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age can not 18 less");
        }
    }

    public void setJob(String job) {
        if (VALID_JOBS.contains(job) == false) {
            throw new IllegalArgumentException("Place work must be Google or Uber or Amazon");
        }
    }

    public void setAddress(String address) {
        if (VALID_ADDRESS.contains(address) == false) {
            throw new IllegalArgumentException("Address must be London or New York or Amsterdam");
        }
    }

    @Override
    public String toString() {
        return String.format("User{name=%s, age=%d, job='%s', address='%s'}", name, age, job, address);
    }
}
