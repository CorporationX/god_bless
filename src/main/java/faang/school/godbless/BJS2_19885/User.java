package faang.school.godbless.BJS2_19885;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    public static Map<User, List<Query>> userQueryMap = new HashMap<>();
    private int id;
    private String name;

    public static void addUser(User user) {
        userQueryMap.putIfAbsent(user, new ArrayList<>());
    }

    public static void removeUser(User user) {
        userQueryMap.remove(user);
    }
}
