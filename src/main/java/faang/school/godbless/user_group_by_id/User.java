package faang.school.godbless.user_group_by_id;

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
    private int age;
    private String job;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        if (users != null) {
            users.stream().forEach(user -> groupUsers.computeIfAbsent(user.getAge(), e -> new ArrayList<>()).add(user));
        }
        return groupUsers;
    }

}
