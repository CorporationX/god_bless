package faang.school.godbless.BJS2_7167;

import java.util.*;

public class User {
    private long id;
    private String name;
    private int age;

    // множество каких-то активностей пользователя
    private HashSet<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> userActivities = new HashMap<>();

        // валидация на null
        if (users == null || activities == null) {
            return null;
        }

        for (var user: users) {
            for (var activity: activities) {
                if (user.getUserActivities().contains(activity)) {
                    userActivities.put(user, activity);
                    break;
                }
            }
        }

        return userActivities;
    }

    public Set<String> getUserActivities() {
        return activities;
    }
}