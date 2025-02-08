package school.faang.BJS2_56414;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> allUsers) {
        if (allUsers == null) {
            return null;
        }
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : allUsers) {
            groupUsers.putIfAbsent(user.getAge(), new ArrayList<>());
            groupUsers.get(user.getAge()).add(user);
        }
        return groupUsers;
    }
}
