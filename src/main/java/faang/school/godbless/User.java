package faang.school.godbless;

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

    public static Map<User, String> findHobbyLovers(List<User> users,
                                             Set<String> activities) {
        Map<User, String> usersMap = new HashMap<>();

        for (User user : users) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    usersMap.put(user, activity);
                    break; // чтобы выйти из цикла, если найдется хотя бы одна общая активность, как и сказано в задании
                }
            }
        }

        if (usersMap.size() == 0) {
            System.out.println("There is no matches between " +
                    "user's activities and got activities");
        }

        return usersMap;
    }
}
