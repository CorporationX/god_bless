package faang.school.godbless;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class User {
    private String name;
    private int age;
    private String companyName;
    private String adress;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            if (result.containsKey(user.getAge())) {
                List<User> currentUsers = result.get(user.getAge());
                currentUsers.add(user);
                result.replace(user.getAge(), currentUsers);
            } else {
                List<User> newUser = new ArrayList<>();
                newUser.add(user);
                result.put(user.getAge(), newUser);
            }
        }
        return result;
    }

}
