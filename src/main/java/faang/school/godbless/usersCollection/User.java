package faang.school.godbless.usersCollection;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        if (users == null || activities == null) {
            throw new IllegalArgumentException("Users and activities must not be null");
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
