package faang.school.godbless;

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
            if (result.containsKey(userAge)) {
                result.get(userAge).add(user);
            } else {
                List<User> s = new ArrayList<>();
                s.add(user);
                result.put(userAge, s);
            }
        }
        return result;
    }
}
