package school.faang.BJS2_85456;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

@Getter
@ToString(includeFieldNames = true)
@AllArgsConstructor
public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            int userAge = user.getAge();
            List<User> list = result.getOrDefault(userAge, new ArrayList<>());
            list.add(user);
            if (!result.containsKey(userAge)) {
                result.put(userAge, list);
            }
        }
        return result;
    }
}
