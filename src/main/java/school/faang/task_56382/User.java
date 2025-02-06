package school.faang.task_56382;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userByAge = new HashMap<>();

        if(users.isEmpty()){
            return userByAge;
        }

        for (User user : users) {
            userByAge.putIfAbsent(user.getAge(), new ArrayList<>());
            userByAge.get(user.getAge()).add(user);
        }
        return userByAge;
    }
}
