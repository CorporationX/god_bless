package faang.school.godbless.users_collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> map = new HashMap<>();

        for (User user : users) {
            for (String activity : user.activities) {
                if (activities.contains(activity)) {
                    map.put(user, activity);
                    break;
                }
            }
        }

        return map;
    }

}
