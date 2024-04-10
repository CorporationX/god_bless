package faang.school.godbless.user;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
    String name;
    int age;
    String job;
    String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            if (!groupedUsers.containsKey(user.getAge())) {
                groupedUsers.put(user.getAge(), new ArrayList<>());
            }
            groupedUsers.get(user.getAge()).add(user);
        }
        return groupedUsers;
    }
}
