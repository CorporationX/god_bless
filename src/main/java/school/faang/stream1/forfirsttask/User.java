package school.faang.stream1.forfirsttask;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {

    private Long id;
    private String name;
    private int age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> people, Set<String> activities) {

        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : people) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}
