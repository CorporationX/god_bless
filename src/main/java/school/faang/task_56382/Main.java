package school.faang.task_56382;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Anton", 26, "it", "Msk"));
        users.add(new User("Kirill", 25, "it", "Msk"));
        users.add(new User("Olga", 21, "Sber", "Spb"));
        users.add(new User("Mikhail", 30, "Office", "Spb"));
        users.add(new User("Mary", 19, "Ozon", "Spb"));
        users.add(new User("Alex", 21, "Vk", "Spb"));
        users.add(new User("Oleg", 26, "Factory", "Msk"));
        users.add(new User("Vladimir", 26, "Yandex", "Msk"));
        users.add(new User("Stepan", 20, "it", "Berlin"));
        users.add(new User("Roman", 30, "Metro", "Msk"));
        users.add(new User("Yuri", 22, "Alfa", "Msk"));

        for (Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()) {
            System.out.printf("Age: %d\n ", entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("\t" + user.toString());
            }
        }
    }
}
