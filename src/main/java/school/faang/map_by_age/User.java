package school.faang.map_by_age;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@ToString
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

    public static HashMap<Integer, List<User>> groupUsers(List<User> users) {
        HashMap<Integer, List<User>> map = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            List<User> list = map.get(age);
            map.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
        }
        return map;
    }
}
