package faang.school.godbless.BJS2_18380;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {

    private long id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {

        Map<User, String> userActivitiesMap = new HashMap<>();

        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (activities.contains(activity)) {
                    userActivitiesMap.put(user, activity);
                }
            }
        }
        return userActivitiesMap;
    }
}