package school.faang.bsj2_85842;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : userList) {
            int age = user.getAge();
            groupUsers.putIfAbsent(age, new ArrayList<>());
            groupUsers.get(age).add(user);
        }
        return groupUsers;
    }
}
