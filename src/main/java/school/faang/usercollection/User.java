package school.faang.usercollection;

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
    private final Set<String> activity;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activity) {
        Map<User, String> map = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.getActivity()) {
                if (activity.contains(hobby)) {
                    map.put(user, hobby);
                    break;
                }
            }
        }
        return map;
    }
}