package faang.school.godbless.task04_collectionUsers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private int age;
    private String name;
    private Set<String> arrayActivities;


    public Map<User, String> findHobbyLovers(List<User> users, Set<String> arrayActivities) {
        Map<User, String> mapActivities = new HashMap<>();
        for (User user:users) {
            for (String activity:user.arrayActivities) {
                if (arrayActivities.contains(activity)) {
                    mapActivities.put(user,activity);
                    break;
                }
            }
        }

        return mapActivities;
    }
}