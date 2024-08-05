package faang.school.godbless.collectUsers;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    String[] activities;
    public static Map<User, String> findHobbyLovers(ArrayList<User> users, HashSet<String> activities){
        Map<User, String> userMap = new HashMap<>();
        for (User user:users){
            for(String activity: user.activities){
                if (activities.contains(activity)){
                    userMap.put(user, activity);
                    break;
                }
            }
        }
        return userMap;
    }
}
