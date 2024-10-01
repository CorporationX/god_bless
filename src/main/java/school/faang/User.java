package school.faang;

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
    private String workplace;
    private String address;


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            int key = user.getAge();
            groupedUsers.computeIfAbsent(key, k -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }
}