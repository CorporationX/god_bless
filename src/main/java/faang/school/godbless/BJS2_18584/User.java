package faang.school.godbless.BJS2_18584;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> userMap = new HashMap<>();
        for (User user : users) {
            for (String activ : user.activities) {
                if (activities.contains(activ)) {
                    userMap.put(user, activ);
                }
            }
        }
        return userMap;
    }
}
