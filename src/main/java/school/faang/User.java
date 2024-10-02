package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        Map<Integer, List<User>> usersMap = new HashMap<>();
        for (User user : usersList) {
            int age = user.getAge();
            usersMap.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
        }
        return usersMap;
    }
}
