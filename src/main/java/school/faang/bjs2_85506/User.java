package school.faang.bjs2_85506;

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

    static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> map = new HashMap<>();

        for (User user : users) {

            int age = user.getAge();
            if (map.containsKey(age)) {
                map.get(age).add(user);

            } else {

                List<User> usersOfAge = new ArrayList<>();
                usersOfAge.add(user);
                map.put(age, usersOfAge);
            }
        }
        return map;
    }
}
