package faang.school.godbless.Collectingusers;

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
    private int age;
    private String name;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> activities) {
        Map<User, String> mapHobbyLovers = new HashMap<>();

        for (User user : userList) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    mapHobbyLovers.put(user, activity);
                }
            }
        }
        return mapHobbyLovers;
    }
}
