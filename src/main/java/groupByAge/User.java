package groupByAge;

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

    public static Map<Integer, List<User>> groupUsers(List<User> listUsers) {
        Map<Integer, List<User>> sortByAge = new HashMap<>();
        for (User user : listUsers) {
            if (sortByAge.containsKey(user.getAge())) {
                sortByAge.get(user.getAge()).add(user);
            } else {
                ArrayList<User> usersSameAge = new ArrayList<>();
                usersSameAge.add(user);
                sortByAge.put(user.getAge(), usersSameAge);
            }
        }
        return sortByAge;
    }
}
