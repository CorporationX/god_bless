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
        var hobbyLovers = new HashMap<User, String>();

        for (var user : users) {
            var activities = user.getActivities();
            var match = findFirstMatch(activities, searchedActivities);

            if (match != null) {
                hobbyLovers.put(user, match);
            }
        }

        return hobbyLovers;
    }

    private static String findFirstMatch(Set<String> set1, Set<String> set2) {
        for (var value : set1) {
            if (set2.contains(value)) {
                return value;
            }
        }
        return null;
    }
}
