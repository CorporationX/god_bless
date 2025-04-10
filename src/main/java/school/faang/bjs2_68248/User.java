package school.faang.bjs2_68248;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

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
