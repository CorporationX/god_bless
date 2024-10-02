package school.faang;

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
    private String address;
    private String job;
    private int age;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            if (result.containsKey(user.getAge())) {
                result.get(user.getAge()).add(user);
            } else {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                result.put(user.getAge(), userList);
            }
        }
        return result;
    }
}
