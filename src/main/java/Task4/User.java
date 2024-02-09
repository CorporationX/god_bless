package Task4;

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

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities){
        Map<User, String> map = new HashMap<>();

        for(User user: users){
            for(Object active: user.getActivities().toArray()) {
                if (activities.contains(active)) {
                    map.put(user, (String) active);
                    break;
                }
            }
        }
        return map;
    }

}
