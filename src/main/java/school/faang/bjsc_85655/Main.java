package school.faang.bjsc_85655;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {

public static void main(String[] args) {
    // Тест 1: Нормальные данные
    List<User> users = Arrays.asList(
            new User("Анна", 25, "Sber", "Москва"),
            new User("Иван", 17, "Yandex", "Санкт-Петербург"),
            new User("Мария", 45, "Uber", "Казань"),
            new User("Петр", 40, "Avito", "Новосибирск"),
            new User("Ольга", 35, "Mail", "Екатеринбург")
    );

    System.out.println("Тест 1 - Нормальные данные:");
    Map<Integer, List<User>> result = User.groupUsers(users); // User.groupUsers!
    result.forEach((age, list) ->
            System.out.println(age + " лет: " + list.size() + " пользователей"));

    // Тест 2: Пустой список
    System.out.println("\nТест 2 - Пустой список:");
    Map<Integer, List<User>> emptyResult = User.groupUsers(Collections.emptyList()); // User.groupUsers!
    System.out.println("Результат: " + emptyResult.size() + " групп");

    // Тест 3: null список
    System.out.println("\nТест 3 - null список:");
    try {
        User.groupUsers(null); // User.groupUsers!
    } catch (IllegalArgumentException e) {
        System.out.println("Поймано исключение: " + e.getMessage());
    }

    // Дополнительный тест: вывод детальной информации
    System.out.println("\nДетальная информация по группам:");
    result.forEach((age, userList) -> {
        System.out.println("\nВозраст " + age + ":");
        for (User user : userList) {
            System.out.println("  - " + user.getName() +
                    " (" + user.getPlaceOfWork() + ", " +
                    user.getAddress() + ")");
        }
    });
}
}


