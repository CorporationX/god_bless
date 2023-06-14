package collector;

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
    private final Set<String> activities = new HashSet<>();

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> similarUsers = new HashMap<>();
        Set<User> copyUsers = new HashSet<>(users);

        for (String activity : activities) {
            for (User user : copyUsers) {
                if (user.activities.contains(activity)) {
                    similarUsers.put(user, activity);
                    copyUsers.remove(user);
                }
            }
        }
        return similarUsers;
    }
}
