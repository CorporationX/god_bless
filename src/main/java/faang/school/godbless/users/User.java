package faang.school.godbless.users;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies){
        Map<User, String> map = new HashMap<>();
        for(User user: users){
            for(String activity : user.getActivities()){
                if(hobbies.contains(activity)){
                    map.put(user, activity);
                    break;
                }
            }
        }
        return map;
    }
}
