package faang.school.godbless.Task_4;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.*;

@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    int id;
    String name;
    int age;
    Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> strings) {

        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (strings.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        return result;
    }
}
