package faang.school.godbless.collecting;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {

    private int id;

    private String name;

    private int age;

    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activitiesFromOutside) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String activity : activitiesFromOutside) {
                if (user.activities.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}
