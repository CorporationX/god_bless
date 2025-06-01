package school.faang.GroupingUsers_BJS2_79142;

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
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> listUsers) {
        Map<Integer, List<User>> mapUsers = new HashMap<>();
        for (User user : listUsers) {
            List<User> listUsersByMap = new ArrayList<>();
            if (mapUsers.get(user.getAge()) == null) {

                listUsersByMap.add(user);
                mapUsers.put(user.getAge(), listUsersByMap);
            } else {
                listUsersByMap = mapUsers.get(user.getAge());
                listUsersByMap.add(user);
                mapUsers.put(user.getAge(),listUsersByMap);
            }
        }
        return mapUsers;
    }
}
