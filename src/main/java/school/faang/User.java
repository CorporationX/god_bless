package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static HashMap<Integer, List<User>> groupUsers(List<User> usersList) {
        HashMap<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : usersList) {
            groupedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return groupedUsers;
    }
}
