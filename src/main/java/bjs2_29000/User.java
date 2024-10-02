package bjs2_29000;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_ALLOWED_AGE = 18;

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Enter your name please...");
        }
        if (age < MIN_ALLOWED_AGE) {
            throw new IllegalArgumentException("You must be over 18 years of age...");
        }
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Something went wrong...");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Unfortunately, we do not work in your region...");
        }

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();

        for (User user : users) {
            int key = user.getAge();
            usersByAge.computeIfAbsent(key, k -> new ArrayList<User>()).add(user);
        }
        return usersByAge;
    }
}
