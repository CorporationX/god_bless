package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class User {
    private Long id;
    private String Name;
    private Long Age;
    private List<String> ActivityList;

    public Map<User, String> findHobbyLovers(List<User> userList, List<String> activityList){
        Map<User, String> map = null;
        for(User u : userList){
            if(u.ActivityList!=null) {
                for (String a : u.ActivityList) {
                    if (activityList.contains(a)) {
                        map.put(u, a);
                    }
                }
            }
        }
        return map;
    }

}
