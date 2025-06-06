package school.faang.bjs2_79217;

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

    static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            if (groupedUsers.containsKey(age)) {
                groupedUsers.get(age).add(user);
            } else {
                groupedUsers.put(age, new ArrayList<>(List.of(user)));
            }
        }

        return groupedUsers;
    }
}
