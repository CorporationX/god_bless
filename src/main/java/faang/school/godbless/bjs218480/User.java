package faang.school.godbless.bjs218480;

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

    String name;
    int age;
    String workPlace;
    String address;

    public User(String name, int age, String workPlace, String address) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        this.age = age;
        if (!VALID_JOBS.contains(workPlace) || workPlace == null) {
            throw new IllegalArgumentException("Bad work place");
        }
        this.workPlace = workPlace;
        if (!VALID_ADDRESSES.contains(address) || address == null) {
            throw new IllegalArgumentException("Bad address");
        }
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