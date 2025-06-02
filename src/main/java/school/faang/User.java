package school.faang;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    private String name;

    private int age;

    private String workplace;

    private String address;

    static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> sortedUsersByAge = new HashMap<>();
        for (User user : users) {
            sortedUsersByAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return sortedUsersByAge;
    }
}
