package school.faang.sprint1.group_user_by_age_58470;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@Getter
public class User {

    private static final int AGE_MIN = 0;
    private static final int AGE_MAX = 110;

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Поле 'имя' не может быть пустым");
        }
        if (age < AGE_MIN || age > AGE_MAX) {
            throw new IllegalArgumentException(String.format("Возраст не может быть больше %d или меньше %d",
                    AGE_MAX, AGE_MIN));
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

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> users = new HashMap<>();
        if (userList != null) {
            for (User user : userList) {
                users.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
            }
        }
        return users;
    }
}
