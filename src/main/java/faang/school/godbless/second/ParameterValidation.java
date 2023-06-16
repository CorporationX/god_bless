package faang.school.godbless.second;

import java.util.Set;

public class ParameterValidation {
    public static void validateParameters(String name, int age, String workplace, Set<String> validJobs, String address,
                                          Set<String> validAddresses) {
        validateName(name);
        validateAge(age);
        validateJob(workplace, validJobs);
        validateAddress(address, validAddresses);
    }
    private static void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("User name is null or empty!");
        }
    }

    private static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("User age is less than 18");
        }
    }

    private static void validateJob(String workplace, Set<String> validJobs) {
        if (!validJobs.contains(workplace)) {
            throw new IllegalArgumentException("User job is not valid");
        }
    }

    private static void validateAddress(String address, Set<String> validAddresses) {
        if (!validAddresses.contains(address)) {
            throw new IllegalArgumentException("User address is not valid");
        }
    }
}
