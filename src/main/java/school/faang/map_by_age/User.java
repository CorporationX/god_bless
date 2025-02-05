package school.faang.map_by_age;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
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

    public static HashMap<Integer, List<User>> map = new HashMap<>();

    public static HashMap<Integer, List<User>> groupUsers(List<User> users) {
        for (User user : users) {
            List<User> list;
            if (map.containsKey(user.age)) {
                list = map.get(user.age);
                list.add(user);
                map.put(user.age, list);
            } else {
                list = new ArrayList<>();
                list.add(user);
                map.put(user.age, list);
            }
        }
        return map;
    }
}
