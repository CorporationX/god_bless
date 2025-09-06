package school.faang.BJS2_85480;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor

public class User {

    private final int id;
    private String name;
    private int age;
    private Set<String> activities;

    static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {

        Map<User, String> map = new HashMap<>();

        if (activities == null || activities.isEmpty()) {
            return map;
        }
        if (users == null || users.isEmpty()) {
            return map;
        }

        for (User user : users) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    map.put(user, activity);
                }
            }
        }
        return map;
    }
}
