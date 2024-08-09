package faang.school.godbless.bjs218461;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    static final int AGE_VALUE = 18;

    String name;
    int age;
    String workPlace;
    String address;

    public User(String name, int age, String workPlace, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < AGE_VALUE) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Bad work place");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Bad address");
        }
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            if (userGroups.containsKey(user.getAge())) {
                userGroups.get(user.getAge()).add(user);
            } else {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                userGroups.put(user.getAge(), userList);
            }
        }
        return userGroups;
    }
}