package school.faang.GroupUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final String name,
                   workplace,
                   address;
    private final int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", workplace='" + workplace + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String name, String workplace, String address, int age) {
        this.name = name;
        this.workplace = workplace;
        this.address = address;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersMap = new HashMap<>();
        for (User user: users) {
            if (usersMap.containsKey(user.getAge())) {
                usersMap.get(user.getAge()).add(user);
            } else {
                usersMap.put(user.getAge(), new ArrayList<>());
                usersMap.get(user.getAge()).add(user);
            }
        }
        return usersMap;
    }
}
