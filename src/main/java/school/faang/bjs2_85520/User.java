package school.faang.bjs2_85520;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> user) {
        Map<Integer, List<User>> usersMap = new HashMap<>();
        for (User users : user) {
            usersMap.computeIfAbsent(users.getAge(), k -> new ArrayList<>()).add(users);
        }
        return usersMap;
    }
}
