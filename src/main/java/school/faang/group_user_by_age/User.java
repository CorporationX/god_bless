package school.faang.group_user_by_age;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private final String name;
    private int age;
    private String company;
    private String address;

    static Map<Integer, List<User>> groupUser(List<User> users, int age) {
        return Map.of(age, users.stream()
                .filter(user -> user.getAge() == age).toList());
    }
}
