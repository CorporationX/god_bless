package school.faang.sprint1.bjs_43887;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final String name;
    @Getter
    private final int age;
    private final String workplace;
    private final String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> group = new HashMap<>();
        for (User user : users) {
            if (!group.containsKey(user.getAge())) {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                group.put(user.getAge(), userList);
            } else {
                group.get(user.getAge()).add(user);
            }
        }

        return group;
    }

    public static void printUserObject(User user) {
        System.out.print("{" + user.name + ", " + user.age
                + ", " + user.workplace + ", " + user.address + "}, ");
    }
}
