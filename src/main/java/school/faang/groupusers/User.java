package school.faang.groupusers;

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
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        if (users.isEmpty() || users == null) {
            return result;
        }
        for (User user : users) {
            if (result.containsKey(user.age)) {
                List<User> list = new ArrayList<>(result.get(user.age));
                list.add(user);
                result.put(user.age, list);
            } else {
                result.put(user.age, List.of(user));
            }
        }
        return result;
    }
}
