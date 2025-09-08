package school.faang;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class User {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> targetActivities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String userActivity : user.getActivities()) {

                if (targetActivities.contains(userActivity)) {

                    result.put(user, userActivity);
                    break;
                }
            }
        }
        return result;
    }
}