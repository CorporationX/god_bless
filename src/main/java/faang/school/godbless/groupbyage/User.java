package faang.school.godbless.groupbyage;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        if (users != null) {
            for (User user : users) {
                groupedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
            }
        }
        return groupedUsers;
    }
}
