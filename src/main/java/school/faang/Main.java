package school.faang;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("Даша", 25, "Google", "Москва"),
                new User("Влад", 30, "Яндекс", "Спб"),
                new User("Никита", 25, "СберБанк", "Москва"),
                new User("Олег", 30, "Uber", "Калининград"),
                new User("Владимир", 29, "Т-банк", "Спб")
        );

        Map<Integer, List<User>> groupedByAge = User.groupUsers(users);

        System.out.println("Пользователи по возрасту:\n========================");
        for (Map.Entry<Integer, List<User>> entry : groupedByAge.entrySet()) {
            System.out.println("Возраст" + entry.getKey() + " лет:");

            for (User user : entry.getValue()) {
                System.out.println(" - " + user);
            }
            System.out.println();
        }

    }
}