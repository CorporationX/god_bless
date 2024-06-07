package faang.school.godbless.group_users;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
    private String work;
    private String address;


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();

        for (User user : users) {
            if (!result.containsKey(user.getAge())) {
                result.put(user.getAge(), new ArrayList<>());
            }
            result.get(user.getAge()).add(user);
        }
        return result;
    }
}