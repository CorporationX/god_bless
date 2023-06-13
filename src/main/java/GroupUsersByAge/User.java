package GroupUsersByAge;

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

    private Integer age;

    private String workPlace;

    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users){

        Map<Integer, List<User>> userGroups = new HashMap<>();

        for (User user : users){
            Integer age = user.age;
            userGroups.computeIfAbsent(age, a -> new ArrayList<>()).add(user);
        }
        return userGroups;
    }
}
