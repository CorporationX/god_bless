package school.faang.task_43890;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@ToString
public class User {
    private String name;
    @Getter
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        users.forEach(user -> groupUsers.computeIfAbsent(user.getAge(), key -> new ArrayList<>()).add(user));
        return groupUsers;
    }

}
