package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
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

    public static Map<Integer,List<User>> groupUsers(List<User> usersList) {
        Map<Integer, List<User>> users = new HashMap<>();

        for (User user : usersList) {
            users.computeIfAbsent(user.age, key -> new ArrayList<>());
            users.get(user.age).add(user);
        }
        return users;
    }

}
