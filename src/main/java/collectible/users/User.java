package collectible.users;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            Set<String> intersection = new HashSet<>(user.activities);
            intersection.retainAll(activities);

            if (intersection.isEmpty()) {
                continue;
            }

            hobbyLovers.put(user, intersection.iterator().next());
        }

        return hobbyLovers;
    }
}
