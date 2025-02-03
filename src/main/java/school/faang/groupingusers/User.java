package school.faang.groupingusers;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> listUsers) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();

        for (User user : listUsers) {
            int age = user.getAge();
            if (usersByAge.containsKey(age)) {
                usersByAge.get(age).add(user);
            } else {
                usersByAge.put(age, new ArrayList<>());
                usersByAge.get(age).add(user);
            }
        }
        return usersByAge;
    }
}
