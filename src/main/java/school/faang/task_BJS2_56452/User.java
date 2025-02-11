package school.faang.task_BJS2_56452;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String adress;

    public static Map<Integer, String> groupUsers(List<User> usersList) {
        Map<Integer, String> usersByAges = new HashMap<>();

        if (usersList.isEmpty()) {
            return usersByAges;
        }

        for (User user : usersList) {
            if (!usersByAges.containsKey(user.getAge())) {
                usersByAges.put(user.getAge(), "");
            }
            usersByAges.put(user.getAge(), usersByAges.get(user.getAge()) + " " + user.getName());
        }
        return usersByAges;
    }
}