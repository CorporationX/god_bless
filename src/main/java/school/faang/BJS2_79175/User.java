package school.faang.BJS2_79175;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class User {
    @ToString.Include
    private String name;
    @Getter
    private int age;
    private String workplace;
    private String address;


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result =  new HashMap<>();

        for (User user : users) {
            int age = user.getAge();

            result.putIfAbsent(age, new ArrayList<>());
            result.get(age).add(user);
        }

        return result;
    }
}
