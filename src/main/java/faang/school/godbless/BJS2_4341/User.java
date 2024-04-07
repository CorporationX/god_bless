package faang.school.godbless.BJS2_4341;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> inputActivities){
        Map<User, String> foundUsers = new HashMap<>();

        for (User user : users){
            for (String activity : user.getActivities()){
                if (inputActivities.contains(activity)){
                    foundUsers.put(user, activity);
                    break;
                }
            }
        }
        return foundUsers;
    }
}
