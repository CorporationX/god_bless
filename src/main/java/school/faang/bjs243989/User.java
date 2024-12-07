package school.faang.bjs243989;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.val;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(@NonNull List<User> users, Set<String> activities) {

        Map<User, String> activityByUser = new HashMap<>();

        for (User user : users) {
            val activity = user.getActivities().stream()
                    .filter(activities::contains)
                    .findFirst().orElse("");

            if (!activity.isEmpty()) {
                activityByUser.put(user, activity);
            }
        }
        return activityByUser;
    }
}
