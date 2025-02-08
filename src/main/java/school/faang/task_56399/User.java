package school.faang.task_56399;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private final int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> inputActivities) {
        Map<User, String> resultMap = new HashMap<>();
        for (User user : users) {
            Set<String> userActivities = user.getActivities();
            for (String activity : userActivities) {
                if (inputActivities.contains(activity)) {
                    resultMap.put(user, activity);
                }
            }
        }
        return resultMap;
    }

}
