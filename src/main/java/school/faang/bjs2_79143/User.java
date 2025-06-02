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
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

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
