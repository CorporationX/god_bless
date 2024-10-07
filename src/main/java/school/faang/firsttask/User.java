package school.faang.firsttask;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class User {
    final private String name;
    final private int age;
    final private String workplace;
    final private String address;

    /**
     * @param users - List of users
     * @return Map of users of the same age
     */
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            groupedUsers.computeIfAbsent(user.getAge(), value -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }
}

