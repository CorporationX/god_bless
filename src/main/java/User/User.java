package User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private String job;
    private String address;
    private int age;

    public int getAge() {
        return age;
    }

    static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            int userAge = user.getAge();
            result.computeIfAbsent(userAge, value -> new ArrayList<>()).add(user);
        }
        return result;
    }
}