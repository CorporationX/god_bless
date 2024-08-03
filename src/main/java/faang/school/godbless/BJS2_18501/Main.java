package faang.school.godbless.BJS2_18501;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 30, "Google", "Moscow, 23"));
        users.add(new User("Bob", 25, "Yandex", "Minsk, 57"));
        users.add(new User("Charlie", 30, "Sber", "Moscow, 43"));
        users.add(new User("David", 25, "Alfa", "Krasnodar, 45"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        for (var entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("  Name: " + user.getName() + ", Workplace: " + user.getWorkPlace() +
                        ", Address: " + user.getAddress());
            }
        }
    }
}
