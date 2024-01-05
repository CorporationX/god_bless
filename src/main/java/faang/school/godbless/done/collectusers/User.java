package faang.school.godbless.done.collectusers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> activities) {
        Map<User, String> usersGroupByActivites = new HashMap<>();

        for (User user : userList) {
            for (String activity : activities) {
                if (user.activities.contains(activity)) {
                    usersGroupByActivites.put(user, activity);
                    break;
                }
            }
        }

        return usersGroupByActivites;
    }
}
