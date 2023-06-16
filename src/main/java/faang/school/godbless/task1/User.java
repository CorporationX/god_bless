package faang.school.godbless.task1;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            if (!groupedUsers.containsKey(user.age)) {
                groupedUsers.put(user.age, new ArrayList<>());
            }
            groupedUsers.get(user.age).add(user);
        }
        return groupedUsers;
    }
}
