package school.faang.task_43976;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@AllArgsConstructor
@ToString
public class User {

    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> listOfUsers) {
        Map<Integer, List<User>> groupingUsers = new HashMap<>();

        for (User user : listOfUsers) {
            int ageUser = user.getAge();
            if (!groupingUsers.containsKey(ageUser)) {
                groupingUsers.put(ageUser, new ArrayList<>());
            }
            groupingUsers.get(ageUser).add(user);
        }

        return groupingUsers;
    }
}
