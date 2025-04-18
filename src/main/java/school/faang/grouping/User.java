package school.faang.grouping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedByAge = new HashMap<>();
        for (User user : users) {
            groupedByAge.putIfAbsent(user.getAge(), new ArrayList<>());
            groupedByAge.get(user.getAge()).add(user);
        }
        return groupedByAge;
    }
}
