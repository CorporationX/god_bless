package faang.school.godbless.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class User {
    private final String name;
    private final int age;
    private final String work;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null || users.isEmpty()) return Map.of();

        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }

}
