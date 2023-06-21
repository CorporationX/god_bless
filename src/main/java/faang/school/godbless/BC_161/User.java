package faang.school.godbless.BC_161;

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
    private Set<String> userActivities;

    public static Map<User, String> findHobbyLovers(List<User>listUsers, Set<String> setActivities) {
        Map<User, String> userStringMap = new HashMap<>();
        for (User user: listUsers) {
            for (String userActivity : user.getUserActivities()) {
                if (setActivities.contains(userActivity)) {
                      userStringMap.put(user, userActivity);
                      break;
                }
            }
        }
                return userStringMap;
    }
}
