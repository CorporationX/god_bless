package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

public record User(int id,
                   String name,
                   int age,
                   Set<String> activities) {

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> activities){
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : userList) {
            for (String activity : activities) {
                if (user.activities.contains(activity)) {
                    hobbyLovers.put(user, activity);
                }
            }
        }
        return hobbyLovers;
    }
}
