package bsj2_28995;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();

        for (User user : users) {
            int key = user.getAge();

            if (usersByAge.containsKey(key)) {
                usersByAge.get(key).add(user);
            } else {
                usersByAge.put(key, new ArrayList<User>());
                usersByAge.get(key).add(user);
            }
        }
        return usersByAge;
    }

}
