package faang.school.godbless.BJS27572;

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
    private String name;
    private int age;
    private String companyName;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();

        for (User user : users) {
            result.computeIfAbsent(user.getAge(), k -> new ArrayList<User>()).add(user);
        }
        return result;
    }
}
