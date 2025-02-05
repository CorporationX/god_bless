package school.faang.BJS2_56352;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class User {
    private final String name;

    private final int age;
    private final String workPlace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        users.forEach(user -> {
            result.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        });
        return result;
    }

}
