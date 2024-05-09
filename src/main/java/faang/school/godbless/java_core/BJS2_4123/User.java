package faang.school.godbless.java_core.BJS2_4123;

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
    Set<String> activities;

    static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();

        for (User user: users) {
            for (String activity: activities) {
                if (user.activities.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }

        return result;
    }
}
