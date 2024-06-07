package faang.school.godbless.usercollection;

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
        Map<User, String> map = new HashMap<>();

        for (User user : users) {
            for (String userActivity : user.getActivities()) {
                if (activities.contains(userActivity)) {
                    map.put(user, userActivity);
                    break;
                }
            }
        }
        return map;
    }
}
