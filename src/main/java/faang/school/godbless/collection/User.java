package faang.school.godbless.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int id;
    private String name;
    private int age;
    private List<String> userActivities;

    public User(int id, String name, int age, List<String> userActivities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userActivities = userActivities;
    }

    public List<String> getUserActivities() {
        return userActivities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, String[] activities){
        Map<User, String> map = new HashMap<>();
        for (User user : users){
            for (String activity : activities){
                if (user.getUserActivities().contains(activity)){
                    map.put(user, activity);
                    break;
                }
            }
        }
        return map;

    }
}