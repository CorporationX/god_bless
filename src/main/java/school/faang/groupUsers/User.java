package school.faang.groupUsers;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : users) {
            int age = user.age;
            map.putIfAbsent(age, new ArrayList<>());
            map.get(age).add(user);
        }
        return map;
    }

    @Override
    public String toString() {
        return "Пользователь: " +
                "имя - " + '\'' + name + '\'' +
                ", возраст - " + age +
                ", место работы - " + '\'' + workplace + '\'' +
                ", адрес - " + '\'' + address + '\'';
    }
}