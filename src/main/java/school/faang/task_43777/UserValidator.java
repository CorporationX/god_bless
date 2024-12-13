package school.faang.task_43777;

import java.util.Set;

class UserValidator {
    private static final Set<String> ALLOWED_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> ALLOWED_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    protected static String validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
        return name;
    }

    protected static Integer validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be greater than or equal to 18");
        }
        return age;
    }

    protected static String validateJob(String job) {
        if (job == null || job.isEmpty()) {
            throw new IllegalArgumentException("Job cannot be null or empty");
        }
        if (!ALLOWED_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job, please select a valid job from the list: " + ALLOWED_JOBS);
        }
        return job;
    }

    protected static String validateAddress(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (!ALLOWED_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(
                    "Invalid address, please select a valid address from the list: " + ALLOWED_ADDRESSES);
        }
        return address;
    }
}