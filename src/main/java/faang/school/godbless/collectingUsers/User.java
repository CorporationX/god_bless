package faang.school.godbless.collectingUsers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@AllArgsConstructor
@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(ArrayList<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    hobbyLovers.put(user, activity);
                }
            }
        }
        return hobbyLovers;
    }
}
