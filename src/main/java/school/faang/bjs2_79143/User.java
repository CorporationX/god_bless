package school.faang.bjs2_79143;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> activities) {
        Map<User, String> result = new HashMap<>();

        users.forEach(user -> {
            user.getActivities().stream()
                    .filter(activities::contains)
                    .findFirst()
                    .ifPresent(activity -> {
                        result.put(user, activity);
                    });
        });

        return result;
    }
}
