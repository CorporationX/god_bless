package faang.school.godbless.BJS2_18377;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private Long id;
    private String name;
    private int age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers (List<User> users, Set<String> findActivities) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (findActivities.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}
