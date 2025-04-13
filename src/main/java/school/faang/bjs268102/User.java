package school.faang.bjs268102;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();
        if (users == null || activities == null) {
            log.info("Empty users[{}] or activities[{}] provided in User::findHobbyLovers. Empty collection returned.",
                    users == null, activities == null);
            return hobbyLovers;
        }

        for (User user : users) {
            String foundActivity = user.getFirstIntersectedActivity(activities);
            if (foundActivity.isBlank()) {
                continue;
            }
            hobbyLovers.put(user, foundActivity);
        }

        return hobbyLovers;
    }

    private String getFirstIntersectedActivity(Set<String> requiredActivities) {
        Set<String> userActivities = this.activities;
        if (userActivities == null || requiredActivities == null) {
            log.info("User have empty activities[{}] or empty required activities[{}] provided for user \"{}\". "
                    + "Empty string returned.", userActivities == null, requiredActivities == null, this.id);
            return "";
        }

        for (String userActivity : userActivities) {
            if (userActivity == null || !requiredActivities.contains(userActivity)) {
                continue;
            }
            return userActivity;
        }

        return "";
    }
}
