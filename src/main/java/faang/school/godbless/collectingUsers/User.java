package faang.school.godbless.collectingUsers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
public class User {

    private int id;

    @Getter
    private String name;

    private int age;

    @Getter
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> userActivityMap = new HashMap<>();
        users.forEach(user -> {
            user.getActivities().forEach(activity -> {
                if(activities.contains(activity)) {
                    userActivityMap.put(user, activity);
                    return;
                }
            });
        });

        return userActivityMap;
    }
}
