package school.faang.sprint1task43927;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    @Setter
    @Getter
    private int age;
    private String workplace;
    private String address;
    private static final List<String> user = new ArrayList<>();

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : users) {
            if (map.containsKey(user.getAge())) {
                List<User> previous = map.get(user.getAge());
                previous.add(user);
                map.put(user.getAge(), previous);
            } else {
                List<User> newList = new ArrayList<>();
                newList.add(user);
                map.put(user.getAge(), newList);
            }
        }
        return map;
    }

    @Override
    public String toString() {
        return "User{"
                +
                "name='" + name + '\''
                +
                ", age=" + age
                +
                ", workplace='" + workplace + '\''
                +
                ", address='" + address + '\''
                +
                '}';
    }
}
