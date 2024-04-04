package faang.school.godbless.BJS2_4514;

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
    private List<String> listActivities;

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> listActivities) {

        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String activity : listActivities) {
                if (user.getListActivities().contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        return result;
    }
}
