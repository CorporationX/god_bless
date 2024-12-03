package school.faang.task_43906;

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
        Map<Integer, List<User>> usersMap = new HashMap<>();
        for (User user : users) {
            if (usersMap.containsKey(user.getAge())) {
                usersMap.get(user.getAge()).add(user);
            } else {
                usersMap.put(user.getAge(), new ArrayList<>());
                usersMap.get(user.getAge()).add(user);
            }
        }
        return usersMap;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", workplace='" + workplace + '\''
                + ", address='" + address + '\''
                + '}';
    }

}
