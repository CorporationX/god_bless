package faang.school.godbless.collectingusers;

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

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            if (user.getActivities() != null) {
                for (String usersActivity : user.getActivities()) {
                    if (activities.contains(usersActivity)) {
                        result.put(user, usersActivity);
                        break;
                    }
                }
            }
        }
        return result;
    }
}
