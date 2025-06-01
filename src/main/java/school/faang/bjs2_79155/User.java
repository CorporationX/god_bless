package school.faang.bjs2_79155;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(int age, String name, String workplace, String address) {
        this.age = age;
        this.name = name;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            groupedUsers.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }

    public static void printGroupedUsers(Map<Integer, List<User>> users) {
        users.forEach((age, list) -> {
            System.out.printf("Пользователи (%s)\n", age);
            list.forEach(user -> {
                System.out.println("Имя: " + user.name);
                System.out.println("Возраст: " + user.age);
                System.out.println("Место работы: " + user.workplace);
                System.out.println("Адрес: " + user.address);
                System.out.println("---------");
            });
        });
    }
}
