package school.faang.sprint_1.task_bjs243928;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final List<User> users = List.of(
                new User("Иван", 18, "Пятерочка", "г. Урюпинск, ул. Ленина д. 1"),
                new User("Петр", 18, "Строймонтаж", "г. Ярославль, ул. Пушкина д. 2"),
                new User("Модест", 30, "ООО Рога и копыта", "г. Тверь, ул. Фета д. 7"),
                new User("Акакий", 30, "ООО Зеленоглазое такси", "г. Шуя, ул. Мира д. 3"),
                new User("Федор", 40, "Сбер", "г. Москва, ул. Маркса д. 77"),
                new User("Педро", 40, "Яндекс", "г. Москва, ул. Танкистов д. 99"),
                new User("Владимир", 40, "Вконтакте", "г. Воронеж, ул. Маркса д. 11"),
                new User("Elon", 53, "SpaceX", "Texas, Houston")
        );
        final Map<Integer, List<User>> usersByAge = User.groupUsers(users);

        System.out.println("BJS2-43928 (Группировка пользователей по возрасту)---------------------------------------");
        System.out.println("Users:");
        users.forEach(System.out::println);

        System.out.println("Grouped users:");
        usersByAge.keySet().stream()
                .sorted()
                .forEach(age -> {
                    System.out.printf("Age %d:\n", age);
                    usersByAge.get(age).forEach(System.out::println);
                });
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
