package collecting.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {

    int id;
    String name;
    int age;
    Set<String> activities;

    public User(int id, Set<String> activities, int age, String name) {
        this.id = id;
        this.activities = activities;
        this.age = age;
        this.name = name;
    }

    public Map<String, User> findHobbyLovers(List<User> users, Set<String> targetActivities) {
        Map<String, User> result = new HashMap<>();

        for (User user : users) {
            for (String hobby : activities) {
                if (targetActivities.contains(activities)) {
                    result.put(hobby, user);
                    break;
                }
            }
        }

        return result;
    }
}
