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
    private final List<String> activity;

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> activity) {
        HashMap<User, String> findUsers = new HashMap<>();

        for (User user : users) {
            Set<String> intersection = new HashSet<>(user.activity);
            intersection.retainAll(activity);

            if (intersection.isEmpty()) {
                continue;
            }

            findUsers.put(user, intersection.iterator().next());
        }

        return findUsers;
    }
}
