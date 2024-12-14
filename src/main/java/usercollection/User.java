package usercollection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> commonSetOfActivities) {
        Map<User, String> usersWithActivities = new HashMap<>();

        for (User user : users) {
            for (String activity : commonSetOfActivities) {
                if (user.getActivities().contains(activity)) {
                    usersWithActivities.put(user, activity);
                }
            }
        }

        return usersWithActivities;
    }
}
