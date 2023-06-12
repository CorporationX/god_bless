package faang.school.godbless.task1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersMap = new HashMap<>();
        for (User user : users) {
            if (!usersMap.containsKey(user.age)) {
                usersMap.put(user.age, new ArrayList<>(List.of(user)));
            } else {
                usersMap.get(user.age).add(user);
            }
        }
        return usersMap;
    }
}
