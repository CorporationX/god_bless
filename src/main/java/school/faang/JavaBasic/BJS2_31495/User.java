package school.faang.JavaBasic.BJS2_31495;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> activities){
        Map<User, String> groupedUsers = new HashMap<>();
        for(User user : userList){
            for(String activity : activities){
                if(user.getActivities().contains(activity)){
                    groupedUsers.put(user, activity);
                    break;
                }
            }
        }
        return groupedUsers;
    }
}
