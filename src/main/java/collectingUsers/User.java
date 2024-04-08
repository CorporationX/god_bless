package collectingUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activitiesSet) {

        Map<User, String> resultMap = new HashMap<User, String>();

        for (User user : users) {
            for (String activity : user.activities) {
                if (activitiesSet.contains(activity)) {
                    resultMap.put(user, activity);
                    break;
                }
            }
        }

        return resultMap;

    }

}
