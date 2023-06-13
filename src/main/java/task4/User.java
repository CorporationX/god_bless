package task4;

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

    public Map<User, Set<String>> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, Set<String>> similarUsers = new HashMap<>();
        for (User user : users) {
            Set<String> himActivities = new HashSet<>(user.getActivities());
            himActivities.retainAll(activities);

            if (!himActivities.isEmpty() && !similarUsers.containsKey(user)) {
                similarUsers.put(user, himActivities);
            }
        }
        return similarUsers;
    }
}