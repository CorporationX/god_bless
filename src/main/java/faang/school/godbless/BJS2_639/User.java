package faang.school.godbless.BJS2_639;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> activity;

    private void findHobbyLovers(List<User> userList, Set<String> userActivity) {
        Map<User, String> userMap = new HashMap<User, String>();
        for (User user : userList) {
            if (userActivity.contains(user.activity)) {
                userMap.put(user, String.valueOf(user.activity));
            }
        }

    }

}
