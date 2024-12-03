package school.faang.task_43673;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public void setName(String name) {
        if (this.name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age cannot less that " + MIN_AGE);
        }
        this.age = age;
    }

    public void setJob(String job) {
        if (VALID_JOBS.contains(job) == false) {
            throw new IllegalArgumentException("Job is not valid");
        }
        this.job = job;
    }

    public void setAddress(String address) {
        if (VALID_ADDRESSES.contains(address) == false) {
            throw new IllegalArgumentException("Address is not valid");
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', age=%d, job='%s', address='%s'}", name, age, job, address);
    }

    public User(String name, int age, String job, String address) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
    }
}
