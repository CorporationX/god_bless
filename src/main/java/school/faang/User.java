package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Builder;

@Getter
@Builder
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersMap = new HashMap<>();

        for (User user : users) {
            usersMap.putIfAbsent(user.getAge(), new ArrayList<>());
            usersMap.get(user.getAge()).add(user);
        }
        return usersMap;
    }
}
