package school.faang.BJS2_56389;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobby;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobby) {
        Map<User, String> groupByHobby = new HashMap<>();
        for (User user : users) {
            user.hobby.retainAll(hobby);
            for (String commonHobby : user.hobby) {
                groupByHobby.put(user, commonHobby);
                break;
            }
        }
        return groupByHobby;
    }
}
