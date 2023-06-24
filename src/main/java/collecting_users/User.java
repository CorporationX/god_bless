package collecting_users;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Setter
@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers (List<User> users, Set<String> hobbies){
        Map<User, String> hobbyLovers = new HashMap<>();

        for(var user: users){
            for (var hobby: hobbies){
                if(user.getActivities().contains(hobby)){
                    hobbyLovers.put(user,hobby);
                    break;
                }
            }
        }
        if(hobbyLovers.isEmpty()){
            return Map.of();
        }

        return hobbyLovers;
    }
}
