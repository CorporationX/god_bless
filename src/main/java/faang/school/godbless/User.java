package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            Set<String> currentActivities = user.getActivities();
            currentActivities.retainAll(activities);
            if (currentActivities.isEmpty()) {
                throw new RuntimeException("User " + user.getName() + " has no activities like in params");
            } else {
                hobbyLovers.put(user, currentActivities.iterator().next());
            }
        }

        return hobbyLovers;
    }
}
