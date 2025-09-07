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
    private String placeOfWork;
    private String address;


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();

        for (User user : users) {
            if (!usersByAge.containsKey(user.age)) {
                usersByAge.put(user.age, new ArrayList<>());
            }
            usersByAge.get(user.age).add(user);
        }
        return usersByAge;
    }

}
