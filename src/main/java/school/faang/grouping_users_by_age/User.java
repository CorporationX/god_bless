package school.faang.grouping_users_by_age;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
public class User {

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым или null");
        }
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Возраст не может быть меньше 0 или больше 120");
        }

        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> users = new HashMap<>();
        for (User user : userList) {
            users.putIfAbsent(user.age, new ArrayList<>());
            users.get(user.age).add(user);
        }
        return users;
    }
}
