package faang.school.godbless.javahashmap.t;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> userActives;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> actives) {
        Map<User, String> collectedUsers = new HashMap<>();

        for (User user: users) {
            for (String userActive: user.getUserActives()) {
               if(actives.contains(userActive)){
                   collectedUsers.put(user,userActive);
                   break;
               }
            }
        }

        return collectedUsers;
    }
}
