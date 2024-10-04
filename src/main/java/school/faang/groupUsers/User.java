package school.faang.groupUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record User (
    String name,
    String age,
    String workPlace,
    String address
) {
    public static Map<String, List<User>> groupUsers(List<User> users) {
        Map<String, List<User>> usersGroup = new HashMap<>();

        for(User user: users) {
            usersGroup.putIfAbsent(user.age(), new ArrayList<>());
            usersGroup.get(user.age()).add(user);
        }

        return usersGroup;
    }
}
