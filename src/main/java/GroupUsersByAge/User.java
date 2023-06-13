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

            if (userGroups.containsKey(age)){
                userGroups.get(age).add(user);
            } else {

                List<User> userList = new ArrayList<>();
                userGroups.put(age, userList);
                userList.add(user);

            }
        }
        return userGroups;
    }
}
