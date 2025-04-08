package school.faang.bjs2_68088;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(Set<User> users, Set<String> enteredActivities) {
        var resultMap = new HashMap<User, String>();

        for (User user : users) {
            if (!resultMap.containsKey(user)) {
                for (String activity : user.getActivities()) {
                    if (enteredActivities.contains(activity)) {
                        resultMap.put(user, activity);
                    }
                }
            }
        }

        return resultMap;
    }
}
