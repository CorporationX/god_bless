package school.faang.bjs2_85515;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    protected static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();

        if (users == null || users.isEmpty()) {
            return groupUsers;
        }

        for (User user : users) {
            int age = user.getAge();
            groupUsers.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
        }

        return groupUsers;
    }
}
