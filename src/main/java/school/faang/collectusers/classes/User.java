package school.faang.collectusers.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> userList, Set<String> activities) {
        Map<User, String> userMap = new HashMap<>();
        for(User user : userList) {
            for (String activity : user.getActivities()) {
                if (activities.contains(activity)) {
                    userMap.put(user, activity);
                    break;
                }
            }
        }
        return userMap;
    }
}