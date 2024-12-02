package school.faang.sprint_1.task_43914;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class User {
    private String user;
    private Integer age;
    private String job;
    private String address;


    static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            groupedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return groupedUsers;
    }
}
