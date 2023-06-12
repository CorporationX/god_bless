import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@EqualsAndHashCode
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> userActions;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> actions) {
        Map<User, String> groupedUsers = new HashMap<>();
        for (User user : users) {
            for (String action : user.userActions) {
                if (actions.contains(action)) {
                    groupedUsers.put(user, action);
                    break;
                }
            }
        }
        return groupedUsers;
    }
}
