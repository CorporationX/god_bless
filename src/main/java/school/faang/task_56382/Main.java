package school.faang.task_56382;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Anton", 26, "it", "Msk"),
                new User("Kirill", 25, "it", "Msk"),
                new User("Olga", 21, "Sber", "Spb"),
                new User("Mikhail", 30, "Office", "Spb"),
                new User("Mary", 19, "Ozon", "Spb"),
                new User("Alex", 21, "Vk", "Spb"),
                new User("Oleg", 26, "Factory", "Msk"),
                new User("Vladimir", 26, "Yandex", "Msk"),
                new User("Stepan", 20, "it", "Berlin"),
                new User("Roman", 30, "Metro", "Msk"),
                new User("Yuri", 22, "Alfa", "Msk"));

        for (Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()) {
            System.out.printf("Age: %d\n ", entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("\t" + user);
            }
            System.out.println(" ");
        }
    }
}
