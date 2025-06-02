package school.faang.bjs2_79159;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class User {
    private final int id;
    private final String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> activitiesToMatch) {
        Map<User, String> matches = new HashMap<>();
        if (users == null || activitiesToMatch == null) {
            return matches;
        }

        users.forEach(user -> {
            if (user.getActivities() == null) {
                return;
            }
            for (String findActivity : activitiesToMatch) {
                if (user.getActivities().contains(findActivity)) {
                    matches.put(user, findActivity);
                    break;
                }
            }
        });

        return matches;
    }

}
