package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> ageSorted = new HashMap<>();

        for (User user : userList) {
            if (!ageSorted.containsKey(user.age)) {
                ageSorted.computeIfAbsent(user.age, age -> new ArrayList<>()).add(user);
            } else {
                ageSorted.get(user.age).add(user);
            }
        }

        return ageSorted;
    }
}
