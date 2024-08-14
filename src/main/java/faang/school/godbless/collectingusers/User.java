package faang.school.godbless.collectingusers;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = new HashSet<>(activities);
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            Set<String> userActivities = user.getActivities();
            for (String activity : activities) {
                if (userActivities.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }

        return result;
    }
}
