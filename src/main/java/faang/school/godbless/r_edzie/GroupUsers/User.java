package faang.school.godbless.r_edzie.GroupUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUser(List<User> userList) {
        Map<Integer, List<User>> groupedUser = new HashMap<>();

        for (User user : userList) {
            int age = user.age;

            if (!groupedUser.containsKey(age)) {
                groupedUser.put(age, new ArrayList<>());
            }

            groupedUser.get(age).add(user);
        }

        return groupedUser;
    }
}
