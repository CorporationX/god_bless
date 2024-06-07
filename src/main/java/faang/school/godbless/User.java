package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Objects.requireNonNull(users);
        Objects.requireNonNull(activities);
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            Set<String> currentActivities = user.getActivities();
            for (String activity : currentActivities) {
                if (activities.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }

        return hobbyLovers;
    }
}
