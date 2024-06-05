package faang.school.godbless;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            Set<String> userActivities = user.getActivities();
            for (String userActivity : userActivities) {
                if (activities.contains(userActivity)) {
                    result.put(user, userActivity);
                    break;
                }
            }
        }
        return result;
    }
}
