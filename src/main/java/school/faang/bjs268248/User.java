package school.faang.bjs268248;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {

    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> grouped = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            if (!grouped.containsKey(age)) {
                grouped.put(age, new ArrayList<>());
            }
            grouped.get(age).add(user);
        }
        return grouped;
    }
}
