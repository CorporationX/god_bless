package school.faang.BJS2_31403;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null) {
            throw new IllegalArgumentException("Given users list was null");
        }

        Map<Integer, List<User>> ageUsersPairs = new HashMap<>();
        for (User user : users) {
            ageUsersPairs.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user);
        }
        return ageUsersPairs;
    }
}
