package school.faang.user.grouping;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupByAge = new HashMap<>();
        for (User user : users) {
            groupByAge.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user);
        }
        return groupByAge;
    }
}
