package faang.school.godbless.Sprint2.task4;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private int id;
    private int age;
    private String name;
    private Set<String> activities;

    public User(int id, int age, String name, Set<String> activities) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activitiesSet) {
        Map<User, String> matchedActivities = new HashMap<>();
        for (User user : users) {
            for (String activity : activitiesSet) {
                if (user.activities.contains(activity)) {
                    matchedActivities.put(user, activity);
                    break;
                }
            }
        }
        return matchedActivities;
    }
}
