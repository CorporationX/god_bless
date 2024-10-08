package usergrouping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> resultMap = new HashMap<>();
        for (var user : users) {
            if (resultMap.containsKey(user.age)) {
                resultMap.get(user.age).add(user);
            } else {
                List<User> sameAgeUserList = new ArrayList<>();
                sameAgeUserList.add(user);
                resultMap.put(user.age, sameAgeUserList);
            }
        }
        return resultMap;
    }
}
