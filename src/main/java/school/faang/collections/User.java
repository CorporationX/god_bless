package school.faang.collections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> newActivities) {
        final Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            for (String activity : newActivities) {

                if (user.getActivities().contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }

        return hobbyLovers;
    }
}
