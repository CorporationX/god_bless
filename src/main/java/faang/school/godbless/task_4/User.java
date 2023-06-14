package faang.school.godbless.task_4;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> usersList, Set<String> activities) {
        Map<User, String> mapHobbyLovers = new HashMap<>();
        for (User user : usersList) {
            for (String userActivity : activities) {
                if (user.activities.contains(userActivity)) {
                    mapHobbyLovers.put(user, userActivity);
                }
            }
        }

        return mapHobbyLovers;
    }
}
