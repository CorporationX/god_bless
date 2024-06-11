package faang.school.godbless.user_registration;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private final String name;
    private final int age;
    private final String placeOfWork;
    private final String address;

    public User(String name, int age, String placeOfWork, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        if (placeOfWork == null || !VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Place of work is incorrect");
        }
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is incorrect");
        }
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }
}
