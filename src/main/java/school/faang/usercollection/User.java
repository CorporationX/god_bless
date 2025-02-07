package school.faang.usercollection;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private final int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(Set<User> users, Set<String> activities) {
        if (users == null || users.isEmpty()) {
            return new HashMap<>();
        }
        if (activities == null || activities.isEmpty()) {
            return new HashMap<>();
        }
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (activities.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}
