package school.faang.collectingusers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    Long id;
    String name;
    Integer age;
    Set<String> activities;

    public static Map<Long, String> findHobbyLovers(Set<User> users, Set<String> activities) {
        Map<Long, String> returnUsers = new HashMap<>();
        for (User user : users) {
            Set<String> userActivities = user.getActivities();
            for (String activity : activities) {
                if (userActivities.contains(activity)) {
                    returnUsers.put(user.id, activity);
                }
            }
        }
        return returnUsers;

    }
}
