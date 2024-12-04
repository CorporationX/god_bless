package school.faang.task_44004;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
@ToString
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> map = new HashMap<>();
        for (User user : users) {
            for (String userHobby : user.hobbies) {
                if (hobbies.contains(userHobby)) {
                    map.put(user, userHobby);
                    break;

                }
            }
        }

        return map;
    }

}
