package faang.school.godbless.bjs218717;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private int age;
    private String name;
    private Set<String> activities = new HashSet<>();

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> activitiesMatch = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    activitiesMatch.put(user, activity);
                    break;
                }
            }
        }
        return activitiesMatch;
    }
}
