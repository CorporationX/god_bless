package school.faang.user.registration;

import java.util.Set;

public class User {
    private String name, placeOfWork, address;
    private int age;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String placeOfWork, String address) {
        validateUserInfo(name, age, placeOfWork, address);

        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    private static void validateUserInfo(String name, int age, String placeOfWork, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (age < 18) {
            throw new IllegalArgumentException("You're younger than 18");
        } else if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Unacceptable job");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
    }
}
