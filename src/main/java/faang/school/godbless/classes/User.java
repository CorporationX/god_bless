package faang.school.godbless.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> activities){
        Map<User, String> resultMap = new HashMap<>();
        for (User user : users){
            for (String hobby : activities){
                if (user.getActivities().contains(hobby)){
                    resultMap.put(user, hobby);
                    break;
                }
            }
        }
        return resultMap;
    }

}
