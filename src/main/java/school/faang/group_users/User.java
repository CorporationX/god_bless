package school.faang.group_users;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class User {

    private String name;
    private Integer age;
    private String workplace;
    private String address;

    static Map<Integer, List<User>> groupUsers(List<User> users) {

        if (users == null) {
            System.out.println("Put in correct parameter");
            return null;
        }

        var mapUsers = new HashMap<Integer, List<User>>();

        for (User user : users) {
            mapUsers.putIfAbsent(user.getAge(), new ArrayList<>(List.of(user)));
            var list = mapUsers.get(user.getAge());
            if (!list.contains(user)) {
                list.add(user);
            }
        }

        return mapUsers;
    }
}
