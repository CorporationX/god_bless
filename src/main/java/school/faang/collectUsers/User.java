package school.faang.collectUsers;

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

    public static Map<User, String> findHobbyLovers(List<User> usersList, Set<String> activityList) {
        Map<User, String> map = new HashMap<>();

        for (User user : usersList) {
            Set<String> usersActivities = user.getActivities();
            for (String activity : usersActivities) {
                if (activityList.contains(activity)) {
                    map.put(user, activity);
                    break;
                }
            }
        }

        return map;
    }
}
