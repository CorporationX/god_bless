package faang.school.godbless.BJS218560;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activity;

    public static HashMap<User, String> findHobbyLovers(List<User> users, Set<String> activity) {
        HashMap<User, String> result = new HashMap<>();
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
