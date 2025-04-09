package school.faang.groupusersage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
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
        Map<Integer, List<User>> usersGroupedByAge = new HashMap<Integer, List<User>>();
        for (User user : users) {
            if (!usersGroupedByAge.containsKey(user.getAge())) {
                usersGroupedByAge.put(user.getAge(), new ArrayList<>());
            }

            usersGroupedByAge.get(user.getAge()).add(user);
        }
        return usersGroupedByAge;
    }
}
