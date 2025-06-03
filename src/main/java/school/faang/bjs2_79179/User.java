package school.faang.bjs2_79179;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> userMap = new HashMap<>();
        if (userList == null || userList.isEmpty()) {
            return userMap;
        }

        for (User user : userList) {
            if (userMap.containsKey(user.getAge())) {
                userMap.get(user.getAge()).add(user);
            } else {
                List<User> list = new ArrayList<>();
                list.add(user);
                userMap.put(user.getAge(), list);
            }
        }
        return userMap;
    }
}
