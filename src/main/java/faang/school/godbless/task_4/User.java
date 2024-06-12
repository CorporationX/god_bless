package faang.school.godbless.task_4;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    static Map<User, String> findHobbyLovers(List<User> userList, Set<String> activities) {
        var map = new HashMap<User, String>();
        userList.forEach(user ->
            activities.forEach(activity -> {
                if (user.activities.contains(activity) && map.get(user) == null) {
                    map.put(user, activity);
                }
            })
        );
        return map;
    }
}
