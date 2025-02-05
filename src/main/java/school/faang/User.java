package school.faang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> userActivities;

    public User(int id, String name, int age, Set<String> userActivities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userActivities = userActivities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> userHobby = new HashMap<>();
        for (User user : users) {
            for (String userActivity : user.userActivities) {
                if (activities.contains(userActivity)) {
                    userHobby.put(user, userActivity);
                }
            }
        }
        return userHobby;
    }

    @Override
    public String toString() {
        return "User " + name;
    }
}
