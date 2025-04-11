package school.faang.bjs2_68261;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@ToString
public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        var groupedUsersByAge = new HashMap<Integer, List<User>>();

        for (var user : users) {
            groupedUsersByAge.putIfAbsent(user.age, new ArrayList<>());
            groupedUsersByAge.get(user.age).add(user);
        }

        return groupedUsersByAge;
    }
}
