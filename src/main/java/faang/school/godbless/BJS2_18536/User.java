package faang.school.godbless.BJS2_18536;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers (List<User> userList, Set<String> activities){
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : userList) {
            for (String activity : activities){
                if (user.getActivities().contains(activity)){
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}
