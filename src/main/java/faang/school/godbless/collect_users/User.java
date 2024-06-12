package faang.school.godbless.collect_users;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> usersActivities;

    public static HashMap<User, String> findHobbyLovers(List<User> users, List<String> activities) {
        Map<User, String> usersHobby = new HashMap<>();
        if (activities != null || !activities.isEmpty()) {
            for (User user : users) {
                if (user.usersActivities != null || !user.usersActivities.isEmpty()) {
                    for (String oneActivity : user.usersActivities) {
                        if (activities.contains(oneActivity)) {
                            usersHobby.put(user, oneActivity);
                            break;
                        }
                    }
                }
            }
        }
        return (HashMap<User, String>) usersHobby;
    }
}
