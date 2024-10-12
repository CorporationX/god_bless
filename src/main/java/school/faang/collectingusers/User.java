package school.faang.collectingusers;

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

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (hobbies.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        return result;
    }
}
