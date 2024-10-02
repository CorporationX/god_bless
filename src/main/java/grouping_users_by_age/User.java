package grouping_users_by_age;

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
    private static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String placeOfWorking;
    private String address;

    public User(String name, int age, String placeOfWorking, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        if (!VALID_JOBS.contains(placeOfWorking)) {
            throw new IllegalArgumentException("Invalid place of working");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.name = name;
        this.age = age;
        this.placeOfWorking = placeOfWorking;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        for (User user : users) {
            usersByAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return usersByAge;
    }
}
