package school.faang;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@ToString
public class User {

    public static final int MIN_AGE = 18;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        // Проверка имени
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }

        // Проверка возраста
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }

        // Проверка места работы
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Место работы должно быть в списке валидных.");
        }

        // Проверка места жительства
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Место жительства должно быть в списке валидных");
        }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        Map<Integer, List<User>> usersMap = new HashMap<>();
        for (User user : usersList) {
            int age = user.getAge();
            usersMap.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
        }
        return usersMap;
    }
}
