package grouping_users_by_age;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private String placeOfWorking;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        for (User user : users) {
            usersByAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return usersByAge;
    }
}
