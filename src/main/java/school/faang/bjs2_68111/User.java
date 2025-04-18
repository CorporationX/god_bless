package school.faang.bjs2_68111;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> targetActivities) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (targetActivities.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }

        return result;
    }
}
