package school.faang.groupusers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.HashMap;


@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
    private String work;
    private String address;

    public static HashMap<Integer, List<String>> groupUsers(List<User> users) {
        HashMap<Integer, List<String>> ageUsers = new HashMap<>();
        for (User user : users) {
            ageUsers.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user.name);
        }
        return ageUsers;
    }
}
