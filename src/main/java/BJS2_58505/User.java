package BJS2_58505;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record User(String name, int age, String job, String address) {
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();

        for (User user : users) {
            if (result.containsKey(user.age)) {
                List<User> usersWithSameAge = result.get(user.age);
                usersWithSameAge.add(user);
            } else {
                List<User> usersWithSameAge = new ArrayList<>();
                usersWithSameAge.add(user);
                result.put(user.age, usersWithSameAge);
            }
        }

        return result;
    }
}
