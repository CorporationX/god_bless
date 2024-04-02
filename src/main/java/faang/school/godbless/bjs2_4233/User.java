package faang.school.godbless.bjs2_4233;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor
public class User {

    private long id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> actives) {
        Map<User, String> userActivityMap = new HashMap<>();
        for (User user : users) {
            for (String activity : user.activities) {
                if (actives.contains(activity)) {
                    userActivityMap.put(user, activity);
                    break;
                }
            }
        }
        return userActivityMap;
    }
}
