package faang.school.godbless.alexbulgakoff.collectusers;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class User {

    private Long id;

    private String name;

    private Integer age;

    private Set<String> activities;

    static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();

        for (User user:users) {
            for (String activity: activities) {
                if (user.getActivities().contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }

        return result;
    }
}
