package faang.school.godbless.BJS2_18397;

import lombok.Getter;

import java.util.*;

@Getter
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

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> resultMap = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (activities.contains(activity)) {
                    resultMap.put(user, activity);
                }
            }
        }
        return resultMap;
    }
}
