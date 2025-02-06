package bjs256504;

import java.util.Set;

public class UserConstructorValidator {
    static void validate(String name, int age, String job, String address, Set<String> jobs, Set<String> addresses) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("The age must not be less than 18");
        }
        if (!jobs.contains(job)) {
            throw new IllegalArgumentException("The place of work must be included in the set");
        }
        if (!addresses.contains(address)) {
            throw new IllegalArgumentException("The address must be included in the set");
        }
    }
}
