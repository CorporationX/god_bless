package school.faang.bjs2_86444;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> targetActivities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String activity : targetActivities) {
                if (user.activities.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }

        return result;
    }
}
