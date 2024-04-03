package faang.school.godbless.Userregistration;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {

    private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");
    private final int MIN_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        this.setName(name);
        this.setAge(age);
        this.setJob(job);
        this.setAddress(address);
    }

    public void setName(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("User name must not be empty");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("User age must be " + MIN_AGE + " or more");
        }
        this.age = age;
    }

    public void setJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(job + " not correct. Job must be is list of valid companies: "
                    + String.join(", ", VALID_JOBS));
        }
        this.job = job;
    }

    public void setAddress(String address) {
        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException(address + " not correct. Address must be in valid cities: "
            + String.join(", ", VALID_ADDRESS));
        }
        this.address = address;
    }

}
