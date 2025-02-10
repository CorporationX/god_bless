package school.faang.BJS2_56389;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> hobby;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobby) {
        Map<User, String> groupByHobby = new HashMap<>();
        for (User user : users) {
            Set<String> temp = new HashSet<>(user.getHobby());
            temp.retainAll(hobby);
            for (String commonHobby : temp) {
                groupByHobby.put(user, commonHobby);
                break;
            }
        }
        return groupByHobby;
    }
}
