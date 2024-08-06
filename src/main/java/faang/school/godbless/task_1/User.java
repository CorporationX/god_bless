package faang.school.godbless.task_1;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class User {
    private String name;
    private int age;
    private String company;
    private String address;


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        var ages = users.stream().map(it -> it.age).toList();
        var groupedUsers = new HashMap<Integer, List<User>>();

        for (var age : ages) {
            groupedUsers.put(age, users.stream().filter(user -> user.age == age).toList());
        }
        return groupedUsers;
    }
}

