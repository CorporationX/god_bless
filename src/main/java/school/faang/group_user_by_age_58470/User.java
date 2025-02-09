package school.faang.group_user_by_age_58470;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
public class User {

    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 110;

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Поле 'имя' не может быть пустым");
        }
        if (age < MIN_AGE || age > MAX_AGE) {
            throw new IllegalArgumentException(String.format("Возраст не может быть больше %d или меньше %d", MAX_AGE, MIN_AGE));
        }
        if (placeOfWork == null || placeOfWork.isBlank()) {
            throw new IllegalArgumentException("Поле 'место работы' не может быть пустым ");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Поле 'адрес' не может быть пустым");
        }

        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUser(List<User> userList) {
        Map<Integer, List<User>> users = new HashMap<>();
        for (User user : userList) {
            users.putIfAbsent(user.age, new ArrayList<>());
            users.get(user.age).add(user);
        }
        return users;
    }
}
