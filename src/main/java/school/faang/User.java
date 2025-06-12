package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String adress;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> sortedUser = new HashMap<>();
        for (User user : users) {
            sortedUser.putIfAbsent(user.getAge(), new ArrayList<>());
            sortedUser.get(user.getAge()).add(user);
        }
        return sortedUser;
    }
}