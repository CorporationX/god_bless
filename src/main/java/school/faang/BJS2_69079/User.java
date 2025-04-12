package school.faang.BJS2_69079;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String company;
    private String address;

    public static Map<Integer, ArrayList<User>> groupUsers(List<User> users) {
        HashMap<Integer, ArrayList<User>> mappedUsers = new HashMap<>();
        users.forEach((User user) -> mappedUsers.computeIfAbsent(user.getAge(), (age) -> new ArrayList<>()).add(user));

        return mappedUsers;
    }
}
