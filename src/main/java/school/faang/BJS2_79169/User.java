package school.faang.BJS2_79169;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> userHobbyMap = new HashMap<>();
        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.getHobbies().contains(hobby)) {
                    userHobbyMap.put(user, hobby);
                    break;
                }
            }
        }
        return userHobbyMap;
    }
}
