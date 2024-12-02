package school.faang.task_43503;

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
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> GroupUsers(List<User> userList) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : userList) {
            if (!groupUsers.containsKey(user.getAge())) {
                List<User> users = new ArrayList<>();
                users.add(user);
                groupUsers.put(user.getAge(), users);
            } else {
                groupUsers.get(user.getAge()).add(user);
            }
        }
        return groupUsers;
    }
}
