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

    public static Map<User, String> findHobbyLovers(List<User> userList, List<String> activitiesList) {
        Map<User, String> matches = new HashMap<>();
        if (userList == null || activitiesList == null) {
            return matches;
        }

        userList.forEach(user -> {
            if (user.activities == null) {
                return;
            }
            for (String findActivity : activitiesList) {
                if (user.activities.contains(findActivity)) {
                    matches.put(user, findActivity);
                    break;
                }
            }
        });

        return matches;
    }

}
