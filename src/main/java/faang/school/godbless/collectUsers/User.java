package faang.school.godbless.collectUsers;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;

    String[] activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities){
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
