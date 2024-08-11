package faang.school.godbless.collecting.users;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {

        Map<User, String> userHobbyMap = new HashMap<>();
        for (User user : users) {
            for (String userActivity : user.activities) {
                if (activities.contains(userActivity)) {
                    userHobbyMap.put(user, userActivity);
                }
            }
        }
        return userHobbyMap;
    }
}
