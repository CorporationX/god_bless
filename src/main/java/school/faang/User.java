package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userMap = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();

            userMap.putIfAbsent(age, new ArrayList<>());

            userMap.get(age).add(user);
        }
        return userMap;
    }


}
