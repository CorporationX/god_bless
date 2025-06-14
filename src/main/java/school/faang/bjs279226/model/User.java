package school.faang.bjs279226.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
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
    }

    public static Map<Integer, List<User>> groupUsersViaStream(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
