package faang.school.godbless.BJS218560;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private final long id;
    private final String name;
    private final int age;
    private final Set<String> activity;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activity) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String element : user.activity) {
                if (activity.contains(element)) {
                    result.put(user, element);
                    break;
                }
            }
        }
        return result;
    }
}
