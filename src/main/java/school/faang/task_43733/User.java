package school.faang.task_43733;

import java.util.Set;

import lombok.Data;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int AGE = 18;
    private String name; 
    private int age;
    private String job;  
    private String address;

    public User(String name, int age, String job, String address) {
        this.name = name; 
        this.age = age; 
        this.job = job; 
        this.address = address;

        validate();
    }

    // Validates all parameters of the User object and throws an exception if any validation fails
    public void validate() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cant be empty");
        }

        if (age < AGE) {
            throw new IllegalArgumentException("Age must be over 18");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The job location must be contained in the VALID_JOBS set");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address must be contained in the VALID_ADDRESSES set");
        }
    }
}
