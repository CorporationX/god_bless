package school.faang.collectionuser;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Data
public class User {

    private int id;
    private final String name;
    private int age;
    private Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(Set<User> users, Set<String> activities) {
        Map<User, String> registry = new HashMap<>();

        for (User user : users) {
            for (String activity : activities) {
                if (user.getHobbies().contains(activity)) {
                    registry.put(user, activity);
                }
            }
        }
        return registry;
    }
}