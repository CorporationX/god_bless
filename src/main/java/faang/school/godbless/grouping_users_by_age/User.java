package faang.school.godbless.grouping_users_by_age;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    private String placeOfWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            if (!groupedUsers.containsKey(user.getAge())) {
                List<User> usersByAge = new ArrayList<>();
                usersByAge.add(user);
                groupedUsers.put(user.getAge(), usersByAge);
            } else {
                groupedUsers.get(user.getAge()).add(user);
            }
        }

        return groupedUsers;
    }
}
