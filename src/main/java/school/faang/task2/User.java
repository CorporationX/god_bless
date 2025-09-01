package school.faang.task2;

import java.util.*;

public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Set<String> getActivities() {
        return activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            String commonActivity = findFirstCommonActivity(user.getActivities(), hobbies);

            if (commonActivity != null) {
                result.put(user, commonActivity);
            }
        }
        return result;
    }

    private static String findFirstCommonActivity(Set<String> userActivities, Set<String> hobbies) {
        for (String activity : userActivities) {
            if (hobbies.contains(activity)) {
                return activity;
            }
        }
        return null; // Если общих активностей нет
    }
}

