package faang.school.godbless;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String name, placeOfWork, address;
    private int age;

    public User(String name, String placeOfWork, String address, int age) {
        this.name = name;
        this.placeOfWork = placeOfWork;
        this.address = address;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public static Map groupUsers(List<User> users) {
        Map<Integer, List> map = new HashMap<Integer, List>();
        Map<List, Integer> UsersTheirAge = new HashMap<>();

        for (User user : users) {
            if ()
            UsersTheirAge.put(user, user.getAge());

        }

        for (User user : users) {
            if (map.containsKey(user.getAge())) {
                map.put(user.getAge(), users);
            }
        }

        return map;
    }
}
