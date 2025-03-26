package school.faang.task_BJS2_56452;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<String>> groupUsers(List<User> usersList) {
        Map<Integer, List<String>> usersByAges = new HashMap<>();

        if ((usersList.isEmpty()) || (usersList == null)) {
            return usersByAges;
        }

        for (User user : usersList) {
            if (!usersByAges.containsKey(user.getAge())) {
                usersByAges.put(user.getAge(), new ArrayList<String>());
            }
            usersByAges.get(user.getAge()).add(user.getName());
        }
        return usersByAges;
    }
}