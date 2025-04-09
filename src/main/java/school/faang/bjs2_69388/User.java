package school.faang.bjs2_69388;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String employer;
    private String address;

    public static Map<Integer, Set<User>> groupUsers(List<User> users) {
        var resultMap = new HashMap<Integer, Set<User>>();

        for (User user : users) {
            if (resultMap.containsKey(user.age)) {
                resultMap.get(user.age).add(user);
            } else {
                resultMap.put(user.age, new HashSet<>(Set.of(user)));
            }
        }

        return resultMap;
    }
}
