package faang.school.godbless.collecting_users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(@NonNull List<User> users, @NonNull Set<String> activities) {
        Map<User, String> usersMap = new HashMap<>();
        for (User user : users) {
            for (String activity : user.activities) {
                if (activities.contains(activity)) {
                    usersMap.put(user, activity);
                    break;
                }
            }
        }
        return usersMap;
    }
}
