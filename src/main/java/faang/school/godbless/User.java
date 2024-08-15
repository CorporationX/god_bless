package faang.school.godbless;

import lombok.Data;
import lombok.val;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    int id;
    String name;
    int age;
    Set<String> activities;

    public Map<User,String> findHobbyLovers(List<User> users,Set<String> activities){
        Map<User,String> matchedHobbyUsers = new HashMap<>();
        for (User user : users) {
            String matchedActivity = null;
            for (String userActivity : user.activities){
                if(activities.contains(userActivity)){
                    matchedActivity = userActivity;
                    break;
                }
            }
            if (matchedActivity!=null){
                matchedHobbyUsers.put(user, matchedActivity);
            }
        }

        return matchedHobbyUsers;
    }
}
