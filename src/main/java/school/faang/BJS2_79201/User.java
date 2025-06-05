package school.faang.BJS2_79201;

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
    private String address;

    static Map<Integer, List<User>> groupUser(List<User> userList) {
        Map<Integer, List<User>> userMap = new HashMap<>();

        for (User user : userList) {
            List<User> userListInMap = new ArrayList<>();
            if (userMap.get(user.age) == null) {
                userListInMap.add(user);
                userMap.put(user.age, userListInMap);
            } else {
                userListInMap = userMap.get(user.age);
                userListInMap.add(user);
            }
        }

        return userMap;
    }
}