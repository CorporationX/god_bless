package faang.school.godbless;

import lombok.*;
import java.util.*;

@Data
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>>groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();

        for (User user : users) {
            result.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return result;
    }
}