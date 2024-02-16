package faang.school.godbless.BJS2_2627;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Data
public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activities;

    public static HashMap<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        var map = new HashMap<User, String>();
        Set<String> activitiesCopy;
        for (var user : users) {
            activitiesCopy = new HashSet<>(user.getActivities());
            activitiesCopy.retainAll(activities);
            if (!activitiesCopy.isEmpty()) {
                map.put(user, (String) activitiesCopy.toArray()[0]);
            }
        }
        return map;
    }
}
