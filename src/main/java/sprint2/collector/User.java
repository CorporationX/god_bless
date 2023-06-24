package sprint2.collector;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private final long id;
    private String name;
    private int age;
    private final Set<String> activities;

    public User(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        activities = new HashSet<>();
    }

    public User(long id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> similarUsers = new HashMap<>();

        for (User user : users) {
            for (String activity : activities) {
                if (user.activities.contains(activity) && !similarUsers.containsKey(user)) {
                    similarUsers.put(user, activity);
                    break;
                }
            }
        }
        return similarUsers;
    }

    public void addActivity(String activity) {
        activities.add(activity);
    }

    public void addActivity(Set<String> activities) {
        this.activities.addAll(activities);
    }
}
