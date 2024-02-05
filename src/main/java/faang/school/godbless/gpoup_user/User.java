package faang.school.godbless.gpoup_user;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> listUser) {
        Map<Integer, List<User>> groupUser = new HashMap<>();
        for (User user : listUser) {
            int age = user.getAge();
            if (!groupUser.containsKey(age)) {
                groupUser.put(age, new ArrayList<>());
            }
            groupUser.get(age).add(user);
        }
        return groupUser;
    }
}
