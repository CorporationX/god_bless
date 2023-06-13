package faang.school.godbless.task_1;

public abstract class UserValidator {
    public static void checkUser(User user){
        checkName(user.getName());
        checkAge(user.getAge());
        checkValidJobs(user.getPlaceOfWork());
        checkValidAddresses(user.getAddress());
    }
    private static void checkName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("User name is null or empty!");
        }
    }

    private static void checkAge(int age) {
        if (age <= 18) {
            throw new IllegalArgumentException("User age must be 18 or over!");
        }
    }

    private static void checkValidJobs(String placeOfWork) {
        if (!User.VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("There is no company with this name");
        }
    }

    private static void checkValidAddresses(String address) {
        if (!User.VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(address + " address does not exist in our database");
        }
    }
}
