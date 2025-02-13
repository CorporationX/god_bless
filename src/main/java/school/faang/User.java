package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record User(String name, int age, String job, String address) {
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        var result = new HashMap<Integer, List<User>>();

        for (User user : users) {
            if (result.containsKey(user.age)) {
                var usersWithSameAge = result.get(user.age);
                usersWithSameAge.add(user);
            } else {
                var usersWithSameAge = new ArrayList<User>();
                usersWithSameAge.add(user);
                result.put(user.age, usersWithSameAge);
            }
        }

        return result;
    }
}
