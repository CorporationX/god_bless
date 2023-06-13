package register_user;


public abstract class UserValidator {
    public static void checkUser(User user){
        checkName(user.name());
        checkAge(user.age());
        checkValidJobs(user.placeOfWork());
        checkValidAddresses(user.address());
    }
    private static void checkName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("User name should not be empty");
        }
    }

    private static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("User age should be 18 or greater!");
        }
    }

    private static void checkValidJobs(String placeOfWork) {
        if (!User.VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("There is no company with such name");
        }
    }

    private static void checkValidAddresses(String address) {
        if (!User.VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(address + " address does not exist");
        }
    }
}
