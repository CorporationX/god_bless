package faang.school.godbless.BJS2_18551;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers (List<User> users, Set<String> activities) {
        Map<User, String> hobbyLoversMap = new HashMap<>();
        for (User user : users) {
            if (!hobbyLoversMap.containsKey(user)) {
                for (String activity : activities) {
                    if (user.activities.contains(activity)) {
                        hobbyLoversMap.put(user, activity);
                        break;
                    }
                }
            }
        }
        return hobbyLoversMap;
    }
}

