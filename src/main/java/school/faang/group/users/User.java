package school.faang.group.users;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class User {
    private String name, placeOfWork, address;
    private int age;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupByAge = new HashMap<>();

        for (User user : users) {
            if (!groupByAge.containsKey(user.age)) groupByAge.put(user.age, new ArrayList<User>());
            groupByAge.get(user.age).add(user);
        }
        return groupByAge;
    }
}
