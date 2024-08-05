package users.group.by.age;

import java.util.Set;


public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_VALID_AGE = 18;

    private final String name;
    private final String workPlace;
    private final String address;
    private final int age;

    public User(String name, String workPlace, String address, int age) {
        if (name.isBlank() || age < MIN_VALID_AGE || !VALID_JOBS.contains(workPlace) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.workPlace = workPlace;
        this.address = address;
        this.age = age;
    }
}
