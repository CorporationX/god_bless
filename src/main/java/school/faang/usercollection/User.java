package school.faang.usercollection;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> activities) {
        if (activities.isEmpty() || users.isEmpty()) {
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
