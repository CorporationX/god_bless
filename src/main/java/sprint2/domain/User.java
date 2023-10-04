package sprint2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    String name;
    int age;
    String placeWork;
    String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String placeWork, String address) {
        if (name == null || name.isBlank() || age < 18
                || !VALID_JOBS.contains(placeWork) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            if (groupUsers.containsKey(user.age)) {
                groupUsers.get(user.age).add(user);
            } else {
                List<User> newGroup = new ArrayList<>();
                groupUsers.put(user.age, newGroup);
                newGroup.add(user);
            }
        }
        return groupUsers;
    }
}
