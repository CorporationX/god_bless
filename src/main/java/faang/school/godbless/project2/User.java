package faang.school.godbless.project2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String placeWork;
    private String address;

    public static Map<Integer, List<User>> groupedUsers(List<User> userList) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : userList){
            int age = user.getAge();
            if(!result.containsKey(age)){
                result.put(age, new ArrayList<>());
            }
            result.get(age).add(user);
        }
        return result;

    }
}


