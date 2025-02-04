package school.faang.group_users_by_age;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> mapSort = new HashMap<>();
        if (users.size() == 0) {
            return mapSort;
        }
        for (User user : users) {
            mapSort.putIfAbsent(user.getAge(), new ArrayList<>());
            mapSort.get(user.age).add(user);
        }
        return mapSort;
    }
}



