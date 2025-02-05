package school.faang.sprint.first.collectingusers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private int id;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> resultMap = new HashMap<>();

        for (var user : users) {
            Set<String> userActivities = user.getActivities();
            userActivities.retainAll(activities);

            if (!userActivities.isEmpty()) {
                resultMap.put(user, userActivities.iterator().next());
            }
        }

        return resultMap;
    }
}
