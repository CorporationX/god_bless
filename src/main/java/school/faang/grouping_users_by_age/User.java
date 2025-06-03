package school.faang.grouping_users_by_age;

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
    private String addressWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            if (result.isEmpty() || !result.containsKey(user.getAge())) {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                result.put(user.getAge(), userList);
            } else {
                List<User> tmp = new ArrayList<>(result.get(user.getAge()));
                tmp.add(user);
                result.put(user.getAge(), tmp);
            }
        }
        return result;
    }
}
