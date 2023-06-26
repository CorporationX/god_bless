package Task4;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
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

    public static Map<User, String> findHobbyLovers(List<User> list, Set<String> activities) {
        Map<User, String> map = new HashMap<>();
        for (User user : list) {
            for (String activiti : user.activities) {
                if (activities.contains(activiti)) {
                    map.put(user, activiti);
                    break;
                }
            }
        }
        return map;
    }
}
