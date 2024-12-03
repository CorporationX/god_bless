package school.faang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> listMap = new HashMap<>();
        for (User user1 : userList) {
            List<User> newUserList = userList.stream().filter(p -> user1.age == p.age).toList();
            listMap.put(user1.age, newUserList);
        }
        return listMap;
    }

}
