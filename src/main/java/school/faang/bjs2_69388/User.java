package school.faang.bjs2_69388;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String employer;
    private String address;

    public static Map<Integer, Set<User>> groupUsers(List<User> users) {
        Map<Integer, Set<User>> resultMap = new HashMap<>();

        for (User user : users) {
            if (resultMap.containsKey(user.getAge())) {
                resultMap.get(user.getAge()).add(user);
            } else {
                resultMap.put(user.getAge(), new HashSet<>(Set.of(user)));
            }
        }

        return resultMap;
    }
}
