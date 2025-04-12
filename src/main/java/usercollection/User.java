package usercollection;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities = new HashSet<>();

    public Map<User, String> findHobbyLovers(List<User> userList, Set<String> targetActivities) {
        Map<User, String> resultMap = new HashMap<>();

        for (User user : userList) {
            for (String activity : user.getActivities()) {
                if (targetActivities.contains(activity)) {
                    resultMap.put(user, activity);
                    break;
                }
            }
        }
        return resultMap;
    }
}
