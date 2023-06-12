package domain;

import lombok.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Value
public class User {
    String name;
    int age;
    String placeWork;
    String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String placeWork, String address) throws IllegalArgumentException {
        if (name == null || age < 18 || !VALID_JOBS.contains(placeWork) || !VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException();

        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            int age = user.age;

            if (groupUsers.containsKey(age))
                groupUsers.get(age).add(user);
            else {
                List<User> newGroup = new ArrayList<>();
                groupUsers.put(age, newGroup);
                newGroup.add(user);
            }
        }
        return groupUsers;
    }
}
