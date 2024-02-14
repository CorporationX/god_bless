package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class User {
    private long id;
    private String name;
    private long age;
    private List<String> activityList;

    public Map<User, String> findHobbyLovers(List<User> userList, List<String> activityList) {
        Map<User, String> map = null;
        for (User u : userList) {
            if (u.activityList != null) {
                for (String a : u.activityList) {
                    if (activityList.contains(a)) {
                        map.put(u, a);
                    }
                }
            }
        }
        return map;
    }

}
