package CollectingUsers;

import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobby = new HashMap<>();

        for (User user : users) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    hobby.put(user, activity);
                }
            }
        }
        return hobby;
    }
}
