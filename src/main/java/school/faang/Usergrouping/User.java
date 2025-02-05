package school.faang.Usergrouping;

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
    private String adress;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            int userAge = user.getAge();
            if (!userGroups.containsKey(userAge)) {
                userGroups.put(userAge, new ArrayList<>());
            }
            userGroups.get(userAge).add(user);

        }
        return userGroups;

    }

}
