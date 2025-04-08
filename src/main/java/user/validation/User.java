package user.validation;

import java.util.Set;

public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, Integer age, String job, String adress) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(adress);
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can-t be blank!");
        }
        this.name = name;
    }

    public void setAge(Integer age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age can-t be under 18!");
        }
        this.age = age;
    }

    public void setJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("This job is invalid!");
        }
        this.job = job;
    }

    public void setAddress(String address) {
        if (!VALID_ADRESSES.contains(address)) {
            throw new IllegalArgumentException("This address is invalid!");
        }
        this.address = address;
    }
}
