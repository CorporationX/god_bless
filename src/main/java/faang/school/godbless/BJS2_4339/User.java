package faang.school.godbless.BJS2_4339;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> usersList){
        Map<Integer, List<User>> userGroups = new HashMap<>();

        for (User user: usersList){
            if(!userGroups.containsKey(user.getAge())){
                userGroups.put(user.getAge(), new ArrayList<>());
            }
            userGroups.get(user.getAge()).add(user);
        }
        return  userGroups;
    }
}
