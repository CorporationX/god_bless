package school.faang.bjs2_79155;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class User {
    private int age;
    private String name;
    private String workplace;
    private String address;

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
                System.out.println("Имя: " + user.getName());
                System.out.println("Возраст: " + user.getAge());
                System.out.println("Место работы: " + user.getWorkplace());
                System.out.println("Адрес: " + user.getAddress());
                System.out.println("---------");
            });
        });
    }
}
