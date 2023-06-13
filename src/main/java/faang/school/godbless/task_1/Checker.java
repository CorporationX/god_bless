package faang.school.godbless.task_1;

public class Checker {
    public static void checkName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("User name is null or empty!");
        }
    }

    public static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("User age must be 18 or over!");
        }
    }

    public static void checkValidJobs(String placeOfWork) {
        if (!User.VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("There is no company with this name");
        }
    }

    public static void checkValidAddresses(String address) {
        if (!User.VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(address + " address does not exist in our database");
        }
    }
}
