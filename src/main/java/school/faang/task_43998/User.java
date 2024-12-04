package school.faang.task_43998;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> searchedActivities) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (var user : users) {
            Set<String> activities = user.getActivities();
            String match = findFirstMatch(activities, searchedActivities);

            if (match != null) {
                hobbyLovers.put(user, match);
            }
        }

        return hobbyLovers;
    }

    private static String findFirstMatch(Set<String> activities, Set<String> searchedActivities) {
        for (var activity : activities) {
            if (searchedActivities.contains(activity)) {
                return activity;
            }
        }
        return null;
    }
}
