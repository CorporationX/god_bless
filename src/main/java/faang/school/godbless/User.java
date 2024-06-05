package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map groupUsers(List<User> usersList) {
        Map<Integer, List<User>> users = new HashMap<>();

        for (User user : usersList) {
            Object value = users.get(user.age);
            if (value != null) {
                users.get(user.age).add(user);
            } else {
                users.put(user.age, new ArrayList<User>());
                users.get(user.age).add(user);
            }
        }
        return users;
    }

}
