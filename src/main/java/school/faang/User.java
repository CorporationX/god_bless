package school.faang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activities;

    public User(int id, String name, int age, List<String> activities){
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> activitiesToCheck){

        Map<User, String> result = new HashMap<>();

        for (User user: users){
            //result.put(user.activities.stream().anyMatch(activitiesToCheck::contains), "");
        }

        return result;
    }
}
