package school.faang.bjs2_56312;

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
    private int age;
    private String work;
    public String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            if (userGroups.containsKey(user.age)) {
                userGroups.get(user.age).add(user);
            } else {
                List<User> userGroup = new ArrayList<>();
                userGroup.add(user);
                userGroups.put(user.age, userGroup);
            }
        }
        return userGroups;
    }

}
