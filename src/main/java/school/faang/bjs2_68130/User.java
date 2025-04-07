package school.faang.bjs2_68130;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedByAgeUsers = new HashMap<>();
        users.forEach(user ->
                groupedByAgeUsers.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user)
        );
        return groupedByAgeUsers;
    }
}
