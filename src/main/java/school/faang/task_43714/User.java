package school.faang.task_43714;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name of user should not be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("User shouldn't be younger than 18 years old");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("This type of job is not present in our system");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("This address is not present in our system");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
