package school.faang.collect_users;

import lombok.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activities;

    public static Map<User, String> findHobbyLovers(List<String> hobbies, List<User> users) {
        Map<User, String> map = new HashMap<>();
        for (User user : users) {
            for (String activity : user.activities) {
                if (hobbies.contains(activity)) {
                    map.put(user, activity);
                }
            }
        }
        return map;
    }
}
