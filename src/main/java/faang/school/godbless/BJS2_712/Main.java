package faang.school.godbless.BJS2_712;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<User, List<Query>> requestsByUsers = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User("John Doe");
        User user2 = new User("Jane Doe");

        // Создаем запросы
        Query query1 = new Query("Select * from users");
        Query query2 = new Query("Insert into products values (1, 'Product')");

        // Добавляем запросы пользователям
        addQuery(user1, query1);
        addQuery(user2, query2);

        // Выводим информацию о пользователях и их запросах
        showAllUserAndQuery();

        // Удаляем пользователя и его запросы
        removeUserAndQuery(user1);

        // Выводим обновленную информацию
        System.out.println("\nAfter removing user1:");
        showAllUserAndQuery();
    }

    public static void addQueries(User user, List<Query> queries) {
        requestsByUsers.put(user, queries);
    }

    public static void addQuery(User user, Query query) {
        requestsByUsers.put(user, new ArrayList<>(List.of(query)));
    }

    public static void removeUserAndQuery(User user) {
        requestsByUsers.remove(user);
    }

    public static void showAllUserAndQuery() {
        requestsByUsers.forEach((user, queries) -> {
            System.out.println(user + " Queries: " + queries);
        });
    }
}