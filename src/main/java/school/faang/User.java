package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users,
                                                    Set<String> targetActivities) {
        Map<User, String> result = new HashMap<>();
        users.forEach(user -> user.activities.stream()
                .filter(activities -> targetActivities.contains(activities))
                .findFirst()
                .ifPresent(activities -> result.computeIfAbsent(user, v -> activities)));
        return result;
    }
}
