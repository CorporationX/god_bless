package faang.school.godbless.BJS2_4339;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;


    public static Map<Integer, List<User>> groupUsers(List<User> usersList){
        Map<Integer, List<User>> userGroups = new HashMap<>();

        for (User user: usersList){
            if(!userGroups.containsKey(user.age)){
                userGroups.put(user.age, new ArrayList<>());
            }
            userGroups.get(user.age).add(user);
        }
        return  userGroups;
    }
}
