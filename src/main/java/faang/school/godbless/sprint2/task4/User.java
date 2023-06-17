package faang.school.godbless.sprint2.task4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> activities) {
        Map<User, String> userActivity = new HashMap<>();
        for (int i = 0; i < userList.size(); ++i) {
            for (String activity : userList.get(i).activities) {
                if (activities.contains(activity)) {
                    userActivity.put(userList.get(i), activity);
                    break;
                }
            }
        }
        return userActivity;
    }
}
