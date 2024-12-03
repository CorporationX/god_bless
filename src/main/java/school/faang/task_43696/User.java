package school.faang.task_43696;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (!name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be blank");
        }

        if (age >= 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be at least 18");
        }

        if (!job.isBlank() && VALID_JOBS.contains(job.trim())) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("Job cannot be blank and must be one of: "
                    + String.join(", ", VALID_JOBS));
        }

        if (!address.isBlank() && VALID_ADDRESSES.contains(address.trim())) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Address cannot be blank and must be one of: "
                    + String.join(", ", VALID_ADDRESSES));
        }
    }

}
