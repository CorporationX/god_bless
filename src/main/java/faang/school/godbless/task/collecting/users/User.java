package faang.school.godbless.task.collecting.users;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        if(users == null || activities == null) {
            return null;
        }
        Map<User, String> userActivityMap = new HashMap<>();

        users.forEach(user -> user.getActivities().forEach(activity -> {
            if(activities.contains(activity)) {
                userActivityMap.put(user, activity);
                return;
            }
        }));

        return userActivityMap;
    }
}
