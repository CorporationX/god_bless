package faang.school.godbless.CollectUsers;

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
public class Users {
    private long id;
    private String name;
    private int age;
    private Set<String> activityUser;

    public static Map<Users, String> findHobbyLovers(List<Users> users, Set<String> activityAll) {
        Map<Users, String> foundHobby = new HashMap<>();
        for (Users user : users) {
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
