package school.faang.task_44017;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
@Getter
@ToString
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        return result;
    }
}
