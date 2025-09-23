package school.faang.sprint1.userregistration;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validateUserData(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateUserData(String name, int age, String job, String address) {

        if (!isNameValid(name)) {
            throw new IllegalArgumentException("Name should not be blank.");
        }

        if (!isAgeValid(age)) {
            throw new IllegalArgumentException("Age should be greater than " + MIN_AGE + ".");
        }

        if (!isJobValid(job)) {
            throw new IllegalArgumentException("Job should be from the list: " + VALID_JOBS + ".");
        }

        if (!isAddressValid(address)) {
            throw new IllegalArgumentException("Address should one of:" + VALID_ADDRESSES + ".");
        }
    }

    private boolean isAddressValid(String address) {
        return VALID_ADDRESSES.contains(address);
    }

    private boolean isJobValid(String job) {
        return VALID_JOBS.contains(job);
    }

    private boolean isAgeValid(int age) {
        return age >= 18;
    }

    private boolean isNameValid(String name) {
        return name != null && !name.isBlank();
    }

}
