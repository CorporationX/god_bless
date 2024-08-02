package users.group.by.age;

import java.util.Arrays;
import java.util.List;


public class User {
    private static final List<String> VALID_JOBS = Arrays.asList("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = Arrays.asList("London", "New York", "Amsterdam");

    private final String name;
    private final String workPlace;
    private final String address;
    private final int age;

    public User(String name, String workPlace, String address, int age) throws IllegalArgumentException {
        if (name.isBlank() || age < 18 || !VALID_JOBS.contains(workPlace) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.workPlace = workPlace;
        this.address = address;
        this.age = age;
    }
}
