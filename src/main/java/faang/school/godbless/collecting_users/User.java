package faang.school.godbless.collecting_users;

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
    private Set<String> activities;
    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> userActivities) {
        Map<User, String> hobby = new HashMap<>();

        for (User user : userList) {
            for (String activity : user.getActivities()) {
                if (userActivities.contains(activity)) {
                    hobby.put(user, activity);
                    break;
                }
            }
        }
        return hobby;
    }
}
