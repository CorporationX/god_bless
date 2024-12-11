package school.faang.sprint_1.task_43793;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserValidator {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public static void validate(String name, int age, String job, String address) {
        List<String> errors = new ArrayList<>();
        validateAndAccumulate(() -> validateName(name), errors);
        validateAndAccumulate(() -> validateAge(age), errors);
        validateAndAccumulate(() -> validateJob(job), errors);
        validateAndAccumulate(() -> validateAddress(address), errors);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }
    }

    public static void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name can't be empty!");
        }
    }

    public static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age can't be less than 18!");
        }
    }

    public static void validateJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Your workplace is not suitable for registration");
        }
    }

    public static void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains((address))) {
            throw new IllegalArgumentException("The address is wrong");
        }
    }

    private static void validateAndAccumulate(Runnable validationSupplier, List<String> errors) {
        try {
            validationSupplier.run();
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }
}
