package school.faang.sprint_1.task_bjs244000;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        if (!validInputParameters(users, activities)) {
            return Collections.emptyMap();
        }

        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            boolean found = false;
            for (String activity : user.activities) {
                if (activities.contains(activity) && !found) {
                    hobbyLovers.put(user, activity);
                    found = true;
                }
            }
        }
        return hobbyLovers;
    }

    private static boolean validInputParameters(List<User> users, Set<String> activities) {
        return users != null && activities != null && !users.isEmpty() && !activities.isEmpty();
    }
}
