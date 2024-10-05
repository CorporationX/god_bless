package school.faang.colect_users_BJS2_31603;

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

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (activities.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }

    public void printHobbyLovers(Map<User, String> hobbyLovers) {
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.printf("User: %s , user activity - %s\n", entry.getKey().getName(), entry.getValue());
        }
    }
}
