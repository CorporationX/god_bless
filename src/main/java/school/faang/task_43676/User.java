package school.faang.task_43676;

import java.util.Set;

public class User {
    private final String name;
    private final Integer age;
    private final String job;
    private final String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, Integer age, String job, String address) throws IllegalArgumentException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cant be blank or null");
        }
        if (age == null || age < 18) {
            throw new IllegalArgumentException("You are too young, lady");
        }
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job must be one of " + VALID_JOBS);
        }
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address must be one of " + VALID_ADDRESSES);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getAddress() {
        return address;
    }
}
