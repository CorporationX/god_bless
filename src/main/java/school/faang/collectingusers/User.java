package school.faang.collectingusers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activities;

    public static HashMap<User, String> findHobbyLovers(List<User> users, List<String> activities) {
        HashMap<User, String> result = new HashMap<>();
        for (User user : users) {
            List<String> usersActivities = user.getActivities();
            if (usersActivities == null) {
                continue;
            }
            for (String usersAct : usersActivities) {
                if (activities.contains(usersAct)) {
                    result.put(user, usersAct);
                    break;
                }
            }
        }
        return result;
    }
}
