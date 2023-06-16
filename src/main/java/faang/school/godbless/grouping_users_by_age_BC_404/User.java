package faang.school.godbless.grouping_users_by_age_BC_404;

import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class User {

    private String name;

    private Integer age;

    private String company;

    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            groupUsers.putIfAbsent(age, new ArrayList<>());
            groupUsers.get(age).add(user);
        }
        return groupUsers;
    }
}
