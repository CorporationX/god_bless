package bjs2_31598;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class User {
    public static final Set<String> VALID_JOBS = new HashSet<>(
            List.of("Google", "Uber", "Amazon")
    );
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(
            List.of("London", "New York", "Amsterdam")
    );

    private String name;
    private Integer age;
    private String job;
    private String address;

    public User(String name, Integer age, String job, String address) {
        if (isUserDataValid(name, age, job, address)) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }

    private static boolean isUserDataValid(String name, Integer age, String job, String address) {
        return isUserNameValid(name) &&
                isUserAgeValid(age) &&
                isUserJobValid(job) &&
                isUserAddressValid(address);
    }

    private static boolean isUserNameValid(String name) {
        if (!name.trim().isEmpty()) {
            return true;
        }
        throw new IllegalArgumentException("Empty user name");
    }

    private static boolean isUserAgeValid(Integer age) {
        if (age >= 18) {
            return true;
        }
        throw new IllegalArgumentException("User is under 18 years old");
    }

    private static boolean isUserJobValid(String job) {
        if (VALID_JOBS.contains(job)) {
            return true;
        }
        throw new IllegalArgumentException("Invalid job");
    }

    private static boolean isUserAddressValid(String address) {
        if (VALID_ADDRESSES.contains(address)) {
            return true;
        }
        throw new IllegalArgumentException("Invalid address");
    }

}
