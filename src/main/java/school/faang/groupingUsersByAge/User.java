package school.faang.groupingUsersByAge;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String addressWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Set<Integer> ages = new HashSet<>();
        for (User user : users) {
            ages.add(user.getAge());
        }
        Map<Integer, List<User>> result = new HashMap<>();
        for (int age : ages) {
            List<User> userListToAge = new ArrayList<>();
            for (User user : users) {
                if (user.getAge() == age) {
                    userListToAge.add(user);
                }
            }
            result.put(age, userListToAge);
        }
        return result;
    }
}