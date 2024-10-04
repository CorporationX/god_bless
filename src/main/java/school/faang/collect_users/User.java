package school.faang.collect_users;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private String activity;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activity) {
        Map<User, String> usersGroup = new HashMap<>();

        for (User user : users) {
            if (activity.contains(user.activity)) {
                usersGroup.put(user, user.activity);
            }
        }
        return usersGroup;
    }
}