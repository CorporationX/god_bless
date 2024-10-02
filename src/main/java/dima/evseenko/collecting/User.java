package dima.evseenko.collecting;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap();

        if(users == null || activities == null)
            throw new IllegalArgumentException("users or activities cannot be null");

        users.forEach(user -> {
            for(String activity : user.getActivities()){
                if(activities.contains(activity)){
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        });
        return hobbyLovers;
    }
}
