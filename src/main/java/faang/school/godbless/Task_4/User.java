package faang.school.godbless.Task_4;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@AllArgsConstructor
@Data
public class User {
    int id;
    String name;
    int age;
    Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> strings) {

        Map<User, String> result = new HashMap<>();

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);

            Iterator<String> iteratorForActivities = user.getActivities().iterator();
            while (iteratorForActivities.hasNext()) {
                String activity = iteratorForActivities.next();
                if (strings.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        return result;
    }
}
