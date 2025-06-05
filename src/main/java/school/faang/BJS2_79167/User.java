package school.faang.BJS2_79167;

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
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> checkUsers) {
        Map<Integer, List<User>> result = new HashMap<>();

        for (User user : checkUsers) {
            int age = user.getAge();
            result.putIfAbsent(age, new ArrayList<>());
            result.get(age).add(user);
        }
        return result;
    }
}