package user.group;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(@NonNull List<User> users) {
        Map<Integer, List<User>> userAges = new HashMap<>();
        for (User user : users) {
            userAges.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return userAges;
    }
}
