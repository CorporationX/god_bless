package BJS2_18525;

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

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        final HashMap<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            if (!groupedUsers.containsKey(user.getAge())) {
                groupedUsers.put(user.getAge(), new ArrayList<>());
            }
            groupedUsers.get(user.getAge()).add(user);
        }

        return groupedUsers;
    }
}
