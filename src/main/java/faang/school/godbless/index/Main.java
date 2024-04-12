package faang.school.godbless.index;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<User, List<Query>> userQuery = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User(1, "Max");
        User user2 = new User(2, "Bob");
        User user3 = new User(3, "Tom");

        List<Query> queries1 = new ArrayList<>();
        Query query1 = new Query(1, "Query 1", LocalDateTime.of(2010,7,16,14,21));
        Query query2 = new Query(2, "Query 2", LocalDateTime.now());
        queries1.add(query1);
        queries1.add(query2);

        List<Query> queries2 = new ArrayList<>();
        Query query3 = new Query(3, "Query 3", LocalDateTime.of(2007, 12,1,11,11));
        Query query4 = new Query(4, "Query 4", LocalDateTime.of(1999, 3,14,13,30));
        queries2.add(query3);
        queries2.add(query4);

        addUser(user1, queries1);
        addUser(user2, queries2);
        displayUsersAndRequests();
        System.out.println("=============>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        addQuery(user3, query3);
        addUser(user3, queries2);
        displayUsersAndRequests();
        System.out.println("=============>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        removeUserAndQueries(user1);
        displayUsersAndRequests();

        System.out.println("=============>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        displayQueryHistory(user2);
    }

    private static void addUser(User user, List<Query> queries) {
        if (!userQuery.containsKey(user)) {
            userQuery.put(user, queries);
            System.out.println("Пользователь " + user.getName() + " добавлен");
        } else {
            System.out.println("Пользователь " + user.getName() + " уже есть в списке");
        }
    }

    private static void addQuery(User user, Query query) {
        if (userQuery.containsKey(user)) {
            List<Query> userQueriesList = userQuery.get(user);
            userQueriesList.add(query);
            userQuery.put(user, userQueriesList);
            System.out.println("Запрос добавлен для пользователя " + user.getName());
        } else {
            System.out.println("Пользователь " + user.getName() + " не найден в списке");
        }
    }

    private static void removeUserAndQueries(User user) {
        if (userQuery.containsKey(user)) {
            userQuery.remove(user);
            System.out.println("Пользователь " + user.getName() + " успешно удален из списка.");

            List<Query> userQueries = userQuery.get(user);
            if (userQueries != null) {
                userQueries.clear();
                System.out.println("Список запросов пользователя " + user.getName() + " очищен");
            } else {
                System.out.println("Список запросов пользователя " + user.getName() + " пуст");
            }
        } else {
            System.out.println("Пользователь " + user.getName() + " не найден в списке.");
        }
    }

    private static void displayUsersAndRequests() {
        if (!userQuery.isEmpty()) {
            for (Map.Entry<User, List<Query>> entry : userQuery.entrySet()) {
                User user = entry.getKey();
                List<Query> queries = entry.getValue();
                System.out.println("Пользователь: " + user.getName());
                System.out.println("Запросы:");
                for (Query query : queries) {
                    System.out.println(query.getId() + ": " + query.getContent() + " - " + query.getTimestamp());
                }
                System.out.println("---------------------");
            }
        } else {
            System.out.println("Коллекция пуста");
        }
    }

    private static void displayQueryHistory(User user) {
        List<Query> queries = userQuery.get(user);
        if (queries == null || queries.isEmpty()) {
            System.out.println("Пользователь " + user.getName() + " не имеет запросов.");
            return;
        }

        queries.sort(Comparator.comparing(Query::getTimestamp));

        System.out.println("История запросов для пользователя " + user.getName() + ":");
        for (Query query : queries) {
            System.out.println(query.getId() + ": " + query.getContent() + " - " + query.getTimestamp());
        }
    }
}

