package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String workingPlace;
    private String address;

    public static Map<Integer, List<User>> transferListUsersToMap(List<User> userList){
        if (userList == null) {return null;}
        Map<Integer, List<User>> resultMap = new HashMap<>();
        for(User user : userList){
            resultMap.putIfAbsent(user.getAge(), new ArrayList<>());
            resultMap.get(user.getAge()).add(user);
        }
        return resultMap;
    }
}