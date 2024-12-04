package school.faang.task_43696;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private static final int MIN_AGE = 18;
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
        if (!name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }

    public void setAge(int age) {
        if (age >= MIN_AGE) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be at least 18");
        }
    }

    public void setJob(String job) {
        if (!job.isBlank() && VALID_JOBS.contains(job.trim())) {
            this.job = job;
        } else {
            throw new IllegalArgumentException(String.format(
                    "Job cannot be blank and must be one of: %s.",
                    String.join(", ", VALID_JOBS)
            ));
        }
    }

    public void setAddress(String address) {
        if (!address.isBlank() && VALID_ADDRESSES.contains(address.trim())) {
            this.address = address;
        } else {
            throw new IllegalArgumentException(String.format(
                    "Address cannot be blank and must be one of: %s.",
                    String.join(", ", VALID_ADDRESSES)
            ));
        }
    }
}
