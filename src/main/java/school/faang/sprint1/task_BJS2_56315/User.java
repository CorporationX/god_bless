package school.faang.sprint1.task_BJS2_56315;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> sortedUsers = new HashMap<>();

        for (User user : users) {
            if (!sortedUsers.containsKey(user.age)) {
                sortedUsers.put(user.age, new ArrayList<>());
            }
            sortedUsers.get(user.age).add(user);
        }

        return sortedUsers;
    }
}
