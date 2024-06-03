package faang.school.godbless.task1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groups = new HashMap<>();
        for (User user : users) {
            if (!groups.containsKey(user.getAge())) {
                groups.put(user.getAge(), new ArrayList<>());
                groups.get(user.getAge()).add(user);
            } else {
                groups.get(user.getAge()).add(user);
            }
        }
        return groups;
    }
}
