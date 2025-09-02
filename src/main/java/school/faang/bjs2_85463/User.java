package school.faang.bjs2_85463;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User { // список всех пользователей1

    private final String name;
    private final int age; // ключ для Map
    private final String work;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();

        // для каждого пользователя в списке users выполнить следующий код
        for (User user : users) {
            // получить возраст пользователя и продолжить обработку1
            int age = user.getAge();

            // если нет списка, создаем
            if (!usersByAge.containsKey(age)) {
                usersByAge.put(age, new ArrayList<>());
            }
            // Добавляем пользователя в список соответствующего возраста1
            usersByAge.get(age).add(user);
        }

        return usersByAge;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Иван ", 20, "яндекс", "1"));
        users.add(new User("Мария", 30, "сбер", "2"));
        users.add(new User("Петр", 20, "сбер", "2"));
        users.add(new User("Анна", 30, "сбер", "2"));
        users.add(new User("Сергей", 20, "яндекс", "1"));

        System.out.println(User.groupUsers(users));
    }

    @Override
    public String toString() {
        return "User{" +
                "name= " + name + ' ' + ", age= " + age +
                ", work= " + work + ' ' + ", address= " + address + ' ' + '}';
    }
}
