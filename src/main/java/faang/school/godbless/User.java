package faang.school.godbless;

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
    private String company;
    private String address;
    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            int userAge = user.getAge();
            if (groupedUsers.containsKey(user.getAge())) {
                groupedUsers.get(userAge).add(user);
            } else {
                groupedUsers.put(userAge, new ArrayList<>(List.of(user)));
            }
        }
        return groupedUsers;
    }
}
