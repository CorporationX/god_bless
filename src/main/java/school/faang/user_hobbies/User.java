package school.faang.user_hobbies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Getter
@ToString
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> userHobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> usersMap = new HashMap<>();
        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.getUserHobbies().contains(hobby)) {
                    usersMap.put(user, hobby);
                    break;
                }
            }
        }
        return usersMap;
    }

}
