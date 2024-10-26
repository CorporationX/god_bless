package school.faang.CollectUsers.BJS231489;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private int userId;
    private String userName;
    private int userAge;
    private Set<String> activities = new HashSet<>();

    private Map<User, String> findHobbyLovers(List<User> users, HashSet<String> hobbies) {
        Map<User, String> map = new HashMap<>();

        for (User user : users) {
            for (String activity: user.getActivities()) {
                if (hobbies.contains(activity)) {
                    map.put(user, activity);
                    break;
                }
            }
        }
        return map;
    }
}
