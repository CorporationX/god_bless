package faang.school.godbless.BJS2_18384;

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

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            String activity = findFirstCommonActivity(user.activities, activities);
            if (!activity.isEmpty()) {
                result.put(user, activity);
            }
        }

        return result;
    }

    private static String findFirstCommonActivity(Set<String> userActivities, Set<String> activities) {
        for (String activity : userActivities) {
            if (activities.contains(activity)) {
                return activity;
            }
        }
        return "";
    }
}
