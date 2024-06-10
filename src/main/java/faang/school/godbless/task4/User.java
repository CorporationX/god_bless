package faang.school.godbless.task4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private Integer age;
    private Set<String> activity;

    public User(UUID id, String name, Integer age, Set<String> activity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activity = activity;
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activity) {
        Map<User, String> result = new HashMap<>();
        for (User user: users) {
            for (String act: user.activity) {
                if (activity.contains(act)) {
                    result.put(user, act);
                    break;
                }
            }
        }
        return result;
    }
}
