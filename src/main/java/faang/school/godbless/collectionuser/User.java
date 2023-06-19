import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(int id, String name, int age, String[] activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = new HashSet<>(List.of(activities));
    }

    public static Map<User, String> findHobbyLovers(User[] users, String[] activities) {
        Map<User, String> mapUsers = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    mapUsers.put(user, activity);
                    break;
                }
            }
        }
        return mapUsers;
    }
}
