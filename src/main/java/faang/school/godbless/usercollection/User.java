package faang.school.godbless.usercollection;

import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.Map;

public record User (int id, String name, int age, Set<String> activities) {

    public static Map<User, String> findHobbyLover(List<User> users, Set<String> activities) {
        Map<User, String> groupUsers = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (user.activities().contains(activity)) {
                    groupUsers.put(user, activity);
                    break;
                }
            }
        }

        return groupUsers;
    }
}
