package school.faang.sprint1.task_43758;

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
        validateArguments(name, age, job, address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateArguments(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name of the user can't be empty!");
        }

        if (age < 18) {
            throw new IllegalArgumentException("User must be of legal age");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The job provided is not in the list of valid jobs");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address provided is not in the list of valid addresses");
        }
    }
}
