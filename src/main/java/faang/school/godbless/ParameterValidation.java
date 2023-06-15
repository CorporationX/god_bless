package faang.school.godbless;

import java.util.Set;

public class ParameterValidation {
    public static void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("User name is null or empty!");
        }
    }

    public static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("User age is less than 18");
        }
    }

    public static void validateJob(String workplace, Set<String> validJobs) {
        if (!validJobs.contains(workplace)) {
            throw new IllegalArgumentException("User job is not valid");
        }
    }

    public static void validateAddress(String address, Set<String> validAddresses) {
        if (!validAddresses.contains(address)) {
            throw new IllegalArgumentException("User address is not valid");
        }
    }
}
