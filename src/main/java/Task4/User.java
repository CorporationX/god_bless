package Task4;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> manyActivities;

    public Map<User, String> findHobbyLovers(List<User> list, List<String> manyActivities) {
        Map<User, String> map = new HashMap<>();
        for (User user : list) {
            for (String activities : manyActivities) {
                if (user.getManyActivities().contains(activities)) {
                    map.put(user, activities);
                    break;
                }
            }
        }
        return map;
    }
}
