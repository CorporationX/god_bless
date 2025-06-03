package school.faang.module1.bjs2_79165;

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

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> targetActivities) {

        Map<User, String> hobbyLovers = new HashMap<>();
        users.forEach(user -> {
            user.getActivities().stream()
                    .filter(targetActivities::contains)
                    .findFirst()
                    .ifPresent(activity -> hobbyLovers.put(user, activity));
        });
        return hobbyLovers;
    }
}
