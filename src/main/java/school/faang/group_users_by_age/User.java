package school.faang.group_users_by_age;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String work;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersGroup = new HashMap<>();
        for (User user : users) {
            usersGroup
                    .computeIfAbsent(user.getAge(), key -> new ArrayList<>())
                    .add(user);
        }
        return usersGroup;
    }
}
