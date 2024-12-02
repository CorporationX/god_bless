package school.faang.sprint_1.task_43886_groupUsers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private Integer age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (var user : users) {
            groupedUsers.computeIfAbsent(user.getAge(), age -> new ArrayList()).add(user);
        }
        return groupedUsers;
    }
}
