package school.faang.CollectUsers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class User {
    private int id;
    private String name;
    private int userAge;
    private Set<String> activities = new HashSet<>();

    private Map<User, String> findHobbyLovers(List<User> users, HashSet<String> strings) {
        Map<User, String> map = new HashMap<>();
        for (User user : users) {
            Set<String> userActivities = new HashSet<>(user.activities);
            userActivities.retainAll(strings);
            if (!userActivities.isEmpty()) {
                map.put(user, userActivities.iterator().next());
            }
        }
        return map;
    }
}
