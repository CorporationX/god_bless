package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activityUser;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activityAll) {
        Map<User, String> foundHobby = new HashMap<>();
        for (User user : users) {
            for (String oneActivityUser : user.getActivityUser()) {
                if (activityAll.contains(oneActivityUser)) {
                    foundHobby.put(user, oneActivityUser);
                    break;
                }
            }
        }
        return foundHobby;
    }
}
