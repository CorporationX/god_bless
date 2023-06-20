package Collecting_users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String name;
    int age;
    private Set<String> activities;

    public static Map<User,String> findHobbyLovers(List<User> users, Set<String> activitiesSet){
        Map<User,String> resultMap = new HashMap<>();
        for(User user: users){
            for(String activity: user.activities){
                if (activitiesSet.contains(activity) && !resultMap.containsKey(user)){
                    resultMap.put(user,activity);
                }
            }
        }
        return resultMap;
    }

}