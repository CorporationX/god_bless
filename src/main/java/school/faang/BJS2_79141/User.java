package school.faang.BJS2_79141;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ToString
@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private HashSet<String> actions;

    public static Map<User, String> findHobbyLovers(List<User> users, HashSet<String> actionsS) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String action : user.getActions()) {
                if (actionsS.contains(action)) {
                    result.put(user, action);
                    break;
                }
            }
        }
        return result;
    }
}
