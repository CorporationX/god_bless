package faang.school.godbless.collectUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class User {

    private String id;
    private String name;
    private Integer age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> usersByHobby = new HashMap<>();

        if (activities == null) {
            return usersByHobby;
        }

        for (User user : users) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    usersByHobby.put(user, activity);
                    break;
                }
            }
        }

        return usersByHobby;
    }
}
