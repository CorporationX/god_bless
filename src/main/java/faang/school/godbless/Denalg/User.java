package faang.school.godbless.Denalg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@ToString
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activities;
    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities){
        Map<User, String> result = new HashMap<>();
        for(User user : users){
            for (String activity : user.getActivities()){
                if (activities.contains(activity)){
                    result.put(user, activity);
                }
            }
        }
        return result;
    }
}

