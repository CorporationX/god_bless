package BJS2_7189;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> hobbies;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> userHobbies = new HashMap<>();

        for (User user : users) {
            for (String activity : activities) {
                if (user.hobbies.contains(activity)) {
                    userHobbies.put(user, activity);
                }
            }
        }
        return userHobbies;
    }
}
