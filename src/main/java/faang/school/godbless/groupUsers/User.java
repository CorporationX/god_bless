package faang.school.godbless.groupUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;

    public User(String name, Integer age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> newUsersList = new HashMap();
        for (User user: users) {
            int key = user.getAge();
            List<User> value = newUsersList.get(key);

            if (value == null) {
                value = new ArrayList<>();
            }

            value.add(user);
            newUsersList.put(user.getAge(), value);
        }

        return newUsersList;
    }
}
