package school.faang.bjs243983;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private Integer age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(Set<User> users, Set<String> activities) {
        Map<User, String> activitiesOfUsers = new HashMap<>();

        for (User user : users) {
            for (String activity : activities) {
                if (user.activities.contains(activity)) {
                    activitiesOfUsers.put(user, activity);
                    break;
                }
            }
        }

        return activitiesOfUsers;
    }
}
