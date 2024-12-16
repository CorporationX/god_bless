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

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : userList) {
            List<User> users = groupUsers.get(user.getAge());
            if (users == null) {
                users = new ArrayList<>();
                groupUsers.put(user.getAge(), users);
            }
            users.add(user);

        }
        return groupUsers;
    }
}
