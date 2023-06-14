package faang.school.godbless.collecting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> userActivities;
    private static Map<User, String> userMap;

    public User(int id, String name, int age, Set<String> userActivities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userActivities = userActivities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        userMap = new HashMap<>();
        for (User user : users) {
            for (String userActivity : user.userActivities) {
                if (activities.contains(userActivity)) {
                    if (userMap.containsKey(user)) {
                        continue;
                    }
                    userMap.put(user, userActivity);
                }
            }
        }
        return userMap;
    }
}
