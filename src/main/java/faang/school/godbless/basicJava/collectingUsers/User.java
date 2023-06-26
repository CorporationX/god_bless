package faang.school.godbless.basicJava.collectingUsers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activitySet;

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> activitySet) {
        Map<User, String> map = new HashMap<>();

        for (User user : userList) {
            Set<String> userActivity = user.getActivitySet();
            for (String activity : userActivity) {
                if (activitySet.contains(activity)) {
                    map.put(user, activity);
                    break;
                }
            }
        }

        return map;
    }
}
