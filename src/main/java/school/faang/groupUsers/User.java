package school.faang.groupUsers;

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
    private String placeOfWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();

        for (User user : users) {
            groupUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return groupUsers;
    }
}