package faang.school.godbless.collecting_users;

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

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {

        Map<User, String> resMap = new HashMap<>();
        for (User user : users) {
            for (String activity : user.activities) {
                if (activities.contains(activity)) {
                    resMap.put(user, activity);
                }
            }
        }
        return resMap;
    }
}

