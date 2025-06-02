package school.faang.weCollectUsers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private final int ID;
    private String name;
    private int age;
    private Set<String> setActivityUser;

    @NonNull
    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> setActivities) {
        Map<User, String> result = new HashMap<>();
        for (User user : userList) {
            for (String activity : setActivities) {
                if (user.getSetActivityUser().contains(activity)) {
                    result.put(user, activity);
                }
            }
        }
        return result;

    }
}
