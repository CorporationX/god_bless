package school.faang.bjs2_79177;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Getter
@AllArgsConstructor
@ToString
public class User {
    private Long id;
    private String name;
    private int age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            for (String act : activities) {
                if (user.getActivities().contains(act)) {
                    result.put(user, act);
                    break;
                }
            }
        }
        return result;
    }
}
