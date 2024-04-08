package faang.school.godbless.BJS2_4627;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> mapUsers = new HashMap<>();
        for (User user : users) {
            if (!mapUsers.containsKey(user.getAge())) {
                mapUsers.put(user.getAge(), new ArrayList<>());
            }
            mapUsers.get(user.getAge()).add(user);
        }
        return mapUsers;
    }
}
