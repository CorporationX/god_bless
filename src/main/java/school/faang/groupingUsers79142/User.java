package school.faang.groupingUsers79142;

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

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> mapUsers = new HashMap<>();
        for (User user : userList) {
            List<User> usersListByAge = new ArrayList<>();
            if (mapUsers.get(user.getAge()) == null) {

                usersListByAge.add(user);
                mapUsers.put(user.getAge(), usersListByAge);
            } else {
                usersListByAge = mapUsers.get(user.getAge());
                usersListByAge.add(user);
                mapUsers.put(user.getAge(), usersListByAge);
            }
        }
        return mapUsers;
    }
}
