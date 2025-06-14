package school.faang;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static school.faang.User.TEXT_AGE;
import static school.faang.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> userList = Arrays.asList(
                new User("Иван", 30, "Google", "Москва"),
                new User("Ольга", 25, "Yandex", "Санкт-Петербург"),
                new User("Дмитрий", 30, "Mail.ru", "Новосибирск"),
                new User("Анна", 25, "Tinkoff", "Казань"),
                new User("Пётр", 40, "Ozon", "Екатеринбург"),
                new User("Мария", 28, "VK", "Москва"),
                new User("Алексей", 35, "Sberbank", "Нижний Новгород"),
                new User("Екатерина", 29, "Wildberries", "Краснодар"),
                new User("Максим", 30, "Tinkoff", "Томск"),
                new User("Анастасия", 27, "Ozon", "Ростов-на-Дону"),
                new User("Сергей", 45, "Roscosmos", "Королёв"),
                new User("Дарья", 22, "HeadHunter", "Уфа"),
                new User("Игорь", 33, "JetBrains", "Санкт-Петербург"),
                new User("Виктория", 33, "MTS PJSC", "Москва"),
                new User("Роман", 37, "ABBYY", "Иркутск")
        );

        Map<Integer, List<User>> groupedUsers = groupUsers(userList);

        for (Integer age : groupedUsers.keySet()) {
            System.out.println(User.TEXT_AGE + age);
            for (User user : groupedUsers.get(age)) {
                System.out.println(user);
            }
        }
    }
}
