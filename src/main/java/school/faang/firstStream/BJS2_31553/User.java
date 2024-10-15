package school.faang.firstStream.BJS2_31553;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> usersWithMatches = new HashMap<>();

        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (activities.contains(activity)) {
                    usersWithMatches.put(user, activity);
                }
            }
        }
        return usersWithMatches;
    }
}
