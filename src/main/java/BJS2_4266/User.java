package BJS2_4266;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for(User user : users) {
            if(!result.containsKey(user.age)) {
                result.put(user.age, new ArrayList<>());
            }
            result.get(user.age).add(user);
        }

        return result;
    }
}
