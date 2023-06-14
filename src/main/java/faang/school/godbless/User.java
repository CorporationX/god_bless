package faang.school.godbless;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Builder
public class User {

    private long id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {

        Map<User, String> usersByActivities = new HashMap<>();

        for (var user : users) {
            Set<String> intersection = new HashSet<>(user.getActivities());
            intersection.retainAll(activities);

            if (!intersection.isEmpty()) {
                usersByActivities.put(user, intersection.iterator().next());
            }
        }

        return usersByActivities;
    }
}
