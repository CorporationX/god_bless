package faang.school.godbless;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private int age;
    private String name;
    private Set<String> activities;


    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> map = new HashMap<>();
        for (User user : users) {
            for (String activity : user.activities) {
                if (activities.contains(activity)) {
                    map.put(user, activity);
                    break;
                }
            }
        }
        return map;
    }
}
