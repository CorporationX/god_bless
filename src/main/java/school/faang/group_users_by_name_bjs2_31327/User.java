package school.faang.group_users_by_name_bjs2_31327;

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
    private String age;
    private String placeOfWork;
    private String address;

    public static Map<String, List<User>> groupUsers(List<User> users) {
        Map<String, List<User>> userGroups = new HashMap<>();

        for (User user : users) {
            if (!userGroups.containsKey(user.getAge())) {
                userGroups.put(user.getAge(), new ArrayList<User>());
                userGroups.get(user.getAge()).add(user);
            } else {
                userGroups.get(user.getAge()).add(user);
            }
        }
        return userGroups;
    }
}
