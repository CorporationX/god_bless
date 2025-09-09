package school.faang.BJS2_85528;

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

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        if (users.isEmpty() || activities.isEmpty()) {
            return new HashMap<>();
        }

        final Map<User, String> mapToReturn = new HashMap<>();

        for (User user : users) {
            for (String activity : activities) {
                if (!user.getActivities().isEmpty() && user.getActivities().contains(activity)) {
                    mapToReturn.put(user, activity);
                    break;
                }
            }
        }
        return mapToReturn;
    }
}