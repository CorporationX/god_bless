package users_registration;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_USER_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validateUser(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateUser(String name, int age, String job, String address) {
        if (age < MIN_USER_AGE) {
            throw new IllegalArgumentException(
                    ErrorMessages.INVALID_USER_AGE + MIN_USER_AGE
            );
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(ErrorMessages.INVALD_USER_JOB);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_USER_ADDRESS);
        }
        if (name != null && name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_USER_NAME);
        }
    }


}
