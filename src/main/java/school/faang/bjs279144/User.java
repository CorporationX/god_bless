package school.faang.bjs279144;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
    private String country;
    private String address;


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();

        for (User user : users) {
            int age = user.age;
            if (!result.containsKey(age)) {
                result.put(age, new ArrayList<>());
            }
            result.get(age).add(user);

        }
        return result;
    }
    @Override
    public String toString() {
        return String.format("User{name='%s', age=%d, country='%s', address='%s'}", name, age, country, address);
    }
}
