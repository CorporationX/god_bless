package faang.school.godbless.CollectingUsers;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> receivedActivities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String activity : user.activities) {
                if (receivedActivities.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        return result;
    }
}
