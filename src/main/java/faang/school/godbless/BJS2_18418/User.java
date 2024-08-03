package faang.school.godbless.BJS2_18418;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public record User(int id, String name, int age, Set<String> activities) {

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> matchedUsers = new HashMap<>();

        users.forEach(user -> {
            String activity = user.activities.stream().filter(activities::contains).findFirst().orElse(null);
            if(activity != null){
                matchedUsers.put(user, activity);
            }
        });

        return matchedUsers;
    }
}
