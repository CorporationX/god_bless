package school.faang.groupusers;

import lombok.ToString;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@RequiredArgsConstructor
public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupedUsersByAge = new HashMap<>();

        for (User user : userList) {
            int userAge = user.getAge();
            groupedUsersByAge.putIfAbsent(userAge, new ArrayList<>());
            groupedUsersByAge.get(userAge).add(user);
        }
        return groupedUsersByAge;
    }
}