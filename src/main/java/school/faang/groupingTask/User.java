package school.faang.groupingTask;

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
    private final String name;
    private final String address;
    private final String workplace;
    private final int age;


    public static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        Map<Integer, List<User>> usersMap = new HashMap<>();

        for (User user : usersList) {
            int age = user.getAge();

            if (usersMap.containsKey(age)) {
                usersMap.get(age).add(user);
            } else {
                usersMap.put(age, new ArrayList<>(List.of(user)));
            }
        }

        return usersMap;
    }
}
