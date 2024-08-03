package faang.school.godbless.by_age;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedByAge = new HashMap<>();
        for (var user : users) {
            int age = user.getAge();
            groupedByAge.computeIfAbsent(age, k -> new ArrayList<User>()).add(user);
        }
        return groupedByAge;
    }
}
