package faang.school.godbless;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> userActivity = new HashSet<>();

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activity) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String activities : activity) {
                if (user.userActivity.contains(activities)) {
                    result.put(user,activities);
                    break;
                }
            }
        }
        return result;
    }
}
