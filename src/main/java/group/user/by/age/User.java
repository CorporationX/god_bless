package group.user.by.age;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private Integer age;
    private String workPlace;
    private String adress;

    protected static Map<Integer, List<User>> groupUsers(List<User> listWithUsers) {
        Map<Integer, List<User>> usersGroupedByAge = new HashMap<>();

        for (User user : listWithUsers) {
            usersGroupedByAge.putIfAbsent(user.getAge(), new ArrayList<>());
            usersGroupedByAge.get(user.getAge()).add(user);
        }

        return usersGroupedByAge;
    }
}
