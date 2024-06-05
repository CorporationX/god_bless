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
        var result = new HashMap<Integer, List<User>>();

        for (User user : users) {
            int age = user.getAge();
            if (result.containsKey(age)) {
                result.get(age).add(user);
            } else {
                result.put(age, new ArrayList<>());
                result.get(age).add(user);
            }
        }
        return result;
    }
}
