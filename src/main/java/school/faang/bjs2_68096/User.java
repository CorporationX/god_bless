package school.faang.bjs2_68096;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();

        users.forEach(user -> {
            var targetActivities = new HashSet<>(activities);
            targetActivities.retainAll(user.activities);
            targetActivities.forEach(activity -> hobbyLovers.put(user, activity));
        });

        return hobbyLovers;
    }
}
