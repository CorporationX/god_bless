package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@EqualsAndHashCode
public class User {
    private int id;
    private String name;
    private int age;
    @Getter private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> listUser, Set<String> activities){
        Map<User, String> userMapHobby = new HashMap<>();
        for(User user : listUser){
            for(String activity : activities){
                if(user.getActivities().contains(activity)){
                    userMapHobby.put(user, activity);
                    break;
                }
            }
        }
        return userMapHobby;
    }
}
