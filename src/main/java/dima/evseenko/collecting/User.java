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

    public Map<User, String> findHobbyLovers(List<User> users){
        Map<User, String> hobbyLovers = new HashMap();

        if(users == null)
            throw new IllegalArgumentException("users is null");

        users.forEach(user -> {
            for(String activity : user.getActivities()){
                if(this.activities.contains(activity)){
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        });
        return hobbyLovers;
    }
}
