package grouping_users_by_age;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String name;
    private int age;
    private String placeOfWorking;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();

        for (User user : users) {
            if (usersByAge.get(user.getAge()) != null) {
                usersByAge.get(user.getAge()).add(user);
            } else {
                usersByAge.put(user.getAge(), new ArrayList<>(List.of(user)));
            }
        }

        return usersByAge;
    }
}
