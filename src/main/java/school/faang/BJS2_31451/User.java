package school.faang.BJS2_31451;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    // Конструктор
    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    // Геттеры для доступа к полям
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getAddress() {
        return address;
    }

    // Статический метод для группировки пользователей по возрасту
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }

    // Переопределим toString для удобного вывода
    @Override
    public String toString() {
        return "User{name='" +
            name + "', age=" +
            age + ", workplace='" +
            workplace + "', address='" +
            address + "'}";
    }
}
