package faang.school.godbless.collectingUsers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> userActivities;

    public Set<String> getUserActivities() {
        return userActivities;
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> allActivities) {
        Map<User, String> matchingActivities = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getUserActivities()) {
                if (allActivities.contains(activity)) {
                    matchingActivities.put(user, activity);
                    break;
                }
            }
        }
        return matchingActivities;
    }
}
