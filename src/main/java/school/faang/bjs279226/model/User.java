package school.faang.bjs279226.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        var usersByAge = new HashMap<Integer, List<User>>();
        for (var user : users) {
            if (!usersByAge.containsKey(user.age)) {
                usersByAge.put(user.age, new ArrayList<>());
            }
            usersByAge.get(user.age).add(user);
        }
        return usersByAge;
        // return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
