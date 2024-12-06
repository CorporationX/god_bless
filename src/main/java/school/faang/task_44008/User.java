package school.faang.task_44008;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private int id;
    private String name;
    private int age;
    @Getter
    private Set<String> activities;

    public static HashMap<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        HashMap<User, String> hobbyLovers = new HashMap<>();

        users.forEach(user -> {
            var sameActivities = user.getActivities().stream().filter(activities::contains).toList();
            if (!sameActivities.isEmpty()) {
                hobbyLovers.put(user, sameActivities.get(0));
            }
        });

        return hobbyLovers;
    }
}
