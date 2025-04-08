package school.faang.bjs2_68182;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsersByAge = new HashMap<>();
        for (User user : users) {
            List<User> groupedUsersList = groupedUsersByAge.getOrDefault(user.getAge(), new ArrayList<>());
            groupedUsersList.add(user);
            groupedUsersByAge.put(user.getAge(), groupedUsersList);
        }
        return groupedUsersByAge;
    }
}
