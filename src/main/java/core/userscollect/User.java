package core.userscollect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String id;

    private String name;

    private int age;

    private Set<String> activities;

    public User(String id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> maps = new HashMap<>();
        for (User user : users) {
            for (String next : activities) {
                if (user.activities.contains(next)) {
                    maps.put(user, next);
                    break;
                }
            }
        }
        return maps;
    }
}
