package collect_users;

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

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbyActivities) {
        Map<User, String> hobbyLoversMap = new HashMap<>();

        if (users == null || hobbyActivities == null) {
            return hobbyLoversMap;
        }

        for (User user : users) {
            for (String activity : hobbyActivities) {
                if (user.getActivities().contains(activity)) {
                    hobbyLoversMap.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLoversMap;
    }
}
