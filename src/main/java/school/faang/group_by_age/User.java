package school.faang.group_by_age;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@AllArgsConstructor
public class User {
    private String name;
    @Getter
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> users = new HashMap<>();
        for (User someUser : userList) {
            users.computeIfAbsent(someUser.getAge(), k -> new ArrayList<>()).add(someUser);
        }
        return users;
    }

    public static void print(Map<Integer, List<User>> myMap) {
        for (Map.Entry<Integer, List<User>> entry : myMap.entrySet()) {
            System.out.printf("%d : %s%n", entry.getKey(), entry.getValue());
        }
    }
}