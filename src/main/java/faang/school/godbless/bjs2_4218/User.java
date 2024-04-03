package faang.school.godbless.bjs2_4218;

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
    private String jobPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupMapUsers = new HashMap<>();

        for (User user : users) {
            groupMapUsers.computeIfAbsent(user.age, key -> new ArrayList<>()).add(user);
        }
        return groupMapUsers;
    }
}
