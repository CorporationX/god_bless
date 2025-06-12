package school.faang.sort_user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            int age = user.age;
            if (result.containsKey(age)) {
                result.get(age).add(user);
            } else {
                List<User> newGroup = new ArrayList<>();
                newGroup.add(user);
                result.put(age, newGroup);
            }

        }
        return result;

    }
}

