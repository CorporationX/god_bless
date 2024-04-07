package faang.school.godbless.BJS2_4614;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String work;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersGroupedByAge = new HashMap<>();
        for (User user : users) {
            if (!(usersGroupedByAge.containsKey(user.age))) {
                usersGroupedByAge.put(user.age, new ArrayList<>());
            }
            usersGroupedByAge.get(user.age).add(user);
        }
        return usersGroupedByAge;
    }

}
