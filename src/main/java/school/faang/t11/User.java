package school.faang.t11;

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
    private Set<String> activs;

    public static Map<User, String> findHobbyLovers(List<User> users,
                                                    Set<String> activities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String userActivity : user.getActivs()) {
                if (activities.contains(userActivity)) {
                    result.put(user, userActivity);
                    break;
                }
            }
        }
        return result;
    }
}