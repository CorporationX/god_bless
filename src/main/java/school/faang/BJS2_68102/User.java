package school.faang.BJS2_68102;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private String[] activities;

    public static Map<User, String> findHobbyLovers(List<User> users, String[] activities) {
        Map<User, String> hobbyLovers = new HashMap<>();
        if (users == null || activities == null) {
            return hobbyLovers;
        }

        Set<String> activitySet = Set.of(
                Arrays.stream(activities)
                        .filter((activity) -> activity != null && !activity.isBlank())
                        .toArray(String[]::new)
        );
        for (User user : users) {
            String foundActivity = user.getFirstIntersectedActivity(activitySet);
            if (foundActivity.isBlank()) {
                continue;
            }

            hobbyLovers.put(user, foundActivity);
        }

        return hobbyLovers;
    }

    private String getFirstIntersectedActivity(Set<String> activities) {
        if (this.activities == null || activities == null) {
            return "";
        }

        for (String activity : this.activities) {
            if (activity == null || !activities.contains(activity)) {
                continue;
            }

            return activity;
        }

        return "";
    }
}
