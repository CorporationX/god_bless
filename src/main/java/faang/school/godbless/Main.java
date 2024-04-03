package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", 18, "Yandex", "Moscow"));
        users.add(new User("Olya", 20, "LANIT", "Moscow"));
        users.add(new User("Andrey", 18, "Sber", "Moscow"));

        Map<Integer,List<User>> groupedUsers = User.groupUsers(users);
        for (Map.Entry<Integer,List<User>> entry : groupedUsers.entrySet()) {
            System.out.printf("Users age: %d %n", entry.getKey());
            for (User user : entry.getValue()) {
                System.out.printf("  Name user: %s %n", user.getName());
                System.out.printf("  Place work user: %s %n", user.getPlaceWork());
                System.out.printf("  Address: %s %n", user.getAddress());
                System.out.println();
            }
            System.out.println("----------------------");
        }
    }
}
