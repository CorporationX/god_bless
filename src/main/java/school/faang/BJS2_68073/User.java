package school.faang.BJS2_68073;

import lombok.Builder;
import lombok.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Builder
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (activities.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        return result;
    }
}