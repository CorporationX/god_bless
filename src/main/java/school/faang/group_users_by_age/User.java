package school.faang.group_users_by_age;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private final String name;
    private int age;
    private String company;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users, int age) {
        return Map.of(age, users.stream()
                .filter(user -> user.getAge() == age).toList());
    }
}
