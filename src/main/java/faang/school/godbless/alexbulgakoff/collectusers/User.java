package faang.school.godbless.alexbulgakoff.collectusers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Getter
@ToString
public class User {

    private Long id;

    private String name;

    private Integer age;

    private Set<String> activities;

    static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();

        users.forEach(user -> {
            user.getActivities().stream()
                    .filter(activities::contains)
                    .map(activity -> new HashSet<>(activities))
                    .forEachOrdered(retain -> {
                retain.retainAll(user.getActivities());
                result.put(user, retain.iterator().next());
            });
        });

        return result;
    }
}
