package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> userMap = new HashMap<>();

        for (User user : users){
            if(userMap.containsKey(user.age)){
                userMap.get(user.age).add(user);
            } else {
                userMap.put(user.age, new ArrayList<>(List.of(user)));
            }
        }
        return userMap;
    }
}
