package school.faang.task43894;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            if (!userGroups.containsKey(user.age)) {
                userGroups.put(user.age, new ArrayList<>());
            }
            userGroups.get(user.age).add(user);
        }
        return userGroups;
    }
}
