package faang.school.godbless.collect_users;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            for (String activity : user.activities) {
                if (activities.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}
