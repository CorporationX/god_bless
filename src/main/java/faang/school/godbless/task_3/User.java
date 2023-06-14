package faang.school.godbless.task_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    public Set<String> activities = new HashSet<>();

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> userAndHobby = new HashMap<>();
        for (User user : users) {
            Optional<String> value = user.activities.stream().filter(activities::contains).findFirst();
            value.ifPresent(s -> userAndHobby.put(user, s));
        }
        return userAndHobby;
    }
}
