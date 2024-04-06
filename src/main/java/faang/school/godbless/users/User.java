package faang.school.godbless.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupByAge = new HashMap<>();
        for (User user : users) {
            int userAge = user.getAge();
            List<User> lUsers;
            if (groupByAge.containsKey(userAge)) {
                lUsers = groupByAge.get(userAge);
            } else {
                lUsers = new ArrayList<>();
            }
            lUsers.add(user);
            groupByAge.put(userAge, lUsers);
        }
        return groupByAge;
    }
}

