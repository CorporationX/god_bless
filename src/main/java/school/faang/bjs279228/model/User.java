package school.faang.bjs279228.model;

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

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();
        users.forEach(user -> {
            user.activities.stream()
                    .filter(activities::contains)
                    .findFirst()
                    .ifPresent(activity -> hobbyLovers.put(user, activity));
        });
        return hobbyLovers;
    }
}
