package school.faang.colect_users_BJS2_31603;

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
    private String activity1;
    private String activity2;
    private String activity3;

    public Map<User, String> findHobbyLovers(List<User> users, List<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            String activity1 = user.activity1;
            String activity2 = user.activity2;
            String activity3 = user.activity3;
            for (String activity : activities) {
                if (activity.equals(activity1)) {
                    hobbyLovers.put(user, activity1);
                } else if (activity.equals(activity2)) {
                    hobbyLovers.put(user, activity);
                } else if (activity.equals(activity3)) {
                    hobbyLovers.put(user, activity);
                }
            }
        }
        return hobbyLovers;
    }
}
