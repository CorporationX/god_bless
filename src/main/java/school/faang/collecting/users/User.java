package school.faang.collecting.users;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Objects.requireNonNull(users, "users cannot be null");
        Objects.requireNonNull(activities, "activities cannot be null");

        Map<User, String> userToActivity = new HashMap<>();
        for(var user : users) {
            user.activities.stream()
                    .filter(activities::contains)
                    .findFirst()
                    .ifPresent(activity -> userToActivity.put(user, activity));
        }
        return userToActivity;
    }
}
