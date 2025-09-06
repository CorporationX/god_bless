package school.faang;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.*;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null) {
            throw new IllegalArgumentException("Список пользователей не может быть null");
        }

        Map<Integer, List<User>> result = new HashMap<>();

        for (User user : users) {
            if (user != null) {
                result.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
            }
        }

        return result;
    }
}