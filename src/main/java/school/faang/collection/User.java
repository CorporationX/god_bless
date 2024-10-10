package school.faang.collection;

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

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> userMap = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    userMap.put(user, activity);
                    break;
                }
            }
        }
        return userMap;
    }
}
