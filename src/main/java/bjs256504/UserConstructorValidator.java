package bjs256504;

import java.util.Objects;
import java.util.Set;

public class UserConstructorValidator {
    static void validate(String name, int age, String job, String address, int validAge, Set<String> validJobs,
                         Set<String> validAddresses) {

        if (Objects.isNull(name) || Objects.isNull(job) || Objects.isNull(address)) {
            throw new IllegalArgumentException("All fields must be filled in");
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if (age < validAge) {
            throw new IllegalArgumentException("The age must not be less than " + validAge);
        }
        if (!validJobs.contains(job)) {
            throw new IllegalArgumentException("Profession " + job + " must be one of the allowed ones: "
                    + validJobs);
        }
        if (!validAddresses.contains(address)) {
            throw new IllegalArgumentException("Address " + address + " must be one of the allowed ones: "
                    + validAddresses);
        }
    }
}
