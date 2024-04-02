package faang.school.godbless.BJS2_4190;

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
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : userList) {
            int age = user.getAge();
            groupedUsers.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }
}
