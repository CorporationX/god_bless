package school.faang.groupingusers;

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
    private String placeWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            if (groupedUsers.containsKey(age)) {
                groupedUsers.get(age).add(user);
            } else {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                groupedUsers.put(age, userList);
            }
        }
        return groupedUsers;
    }
}


