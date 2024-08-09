package faang.school.godbless.BJS2_18418;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public record User(int id, String name, int age, Set<String> activities) {

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> matchedUsers = new HashMap<>();

        for (User user : users) {
            for (String activity : user.activities) {
                if (activities.contains(activity)) {
                    matchedUsers.put(user, activity);
                    break;
                }
            }
        }

        return matchedUsers;
    }
}
