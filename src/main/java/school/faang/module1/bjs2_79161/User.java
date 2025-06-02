package school.faang.module1.bjs2_79161;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {

    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            List<User> userList = groupedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>());
            userList.add(user);
        }
        return groupedUsers;
    }
}
