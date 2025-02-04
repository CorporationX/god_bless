package school.faang.BJS2_58518;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {

    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> resultMap = new HashMap<>();

        if (users.size() == 0) {
            return null;
        }

        for (User user : users) {
            Integer key = user.getAge();
            if (!resultMap.containsKey(key)) {
                resultMap.put(key, new ArrayList<>());
            } else {
                resultMap.get(key).add(user);
            }
        }

        return resultMap;
    }


}
