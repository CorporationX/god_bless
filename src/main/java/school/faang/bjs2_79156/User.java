package school.faang.bjs2_79156;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class User {
    private int id;
    @ToString.Include
    private String name;
    private int age;
    @Getter
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            Set<String> userActivities = user.getActivities();

            for (String activity : activities) {
                if (userActivities.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }

        return result;
    }
}
