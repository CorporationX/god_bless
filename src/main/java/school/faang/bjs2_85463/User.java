package school.faang.bjs2_85463;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> ageToUser = new HashMap<>();
        for (User user : users) {
            ageToUser.putIfAbsent(user.getAge(), new ArrayList<>());
            ageToUser.get(user.getAge()).add(user);
        }
        return ageToUser;
    }
}
