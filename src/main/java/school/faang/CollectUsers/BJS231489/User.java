package school.faang.CollectUsers.BJS231489;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int userId;
    private String userName;
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
