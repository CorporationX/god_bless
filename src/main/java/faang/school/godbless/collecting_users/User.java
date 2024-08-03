package faang.school.godbless.collecting_users;

import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
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

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> activitySet) {
        Map<User, String> userMap = new HashMap<>();

        for (User user : userList) {
            for (String activity : activitySet) {
                if (user.activities.contains(activity)) {
                    userMap.put(user, activity);
                }
            }
        }
        for (Map.Entry<User, String> entry : userMap.entrySet()) {
            System.out.println("Key > " + entry.getKey() + " - value > " + entry.getValue());
        }

        return userMap;
    }
}
