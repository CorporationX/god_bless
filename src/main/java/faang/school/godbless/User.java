package faang.school.godbless;

import java.util.*;

public class User {
    private long id;
    private String name;
    private int age;

    // множество каких-то активностей пользователя
    private HashSet<String> activities;

    public static HashMap<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        HashMap<User, String> userActivities = new HashMap<>();

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

    public HashSet<String> getUserActivities() {
        return activities;
    }
}