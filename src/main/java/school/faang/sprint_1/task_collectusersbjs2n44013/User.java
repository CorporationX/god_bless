package school.faang.sprint_1.task_collectusersbjs2n44013;

import lombok.Getter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private final int id;
    private String name;
    private int age;
    private final Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> activitiesSet) {
        Map<User, String> map = new HashMap<>();
        for (User user : userList) {
            for (String act : user.activities) {
                if (activitiesSet.contains(act)) {
                    map.put(user, act);
                }
            }
        }
        return map;
    }
}
