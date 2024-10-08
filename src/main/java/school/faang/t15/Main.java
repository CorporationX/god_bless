package school.faang.t15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static HashMap<User, List<Query>> userQueries = new HashMap<>();

    public static void main(String[] args) {

        User userVasya = new User(1, "Vasya");
        User userMasya = new User(2, "Masya");

        addUser(userVasya);
        addUser(userMasya);

        addQuery(userVasya, new Query(1, "Как пропасть в Discord?"));
        addQuery(userVasya, new Query(2, "Что такое Java?"));
        addQuery(userMasya, new Query(3, "Что такое индексации запросов пользователей?"));

        System.out.println("Все пользователи и их запросы:");
        printAllUsersAndQueries();

        System.out.println("\nИстория запросов от Vasya:");
        printUserQueryHistory(userVasya);

        System.out.println("\nУдаление Masya...");
        removeUser(userMasya);

        System.out.println("\nВсе пользователи и их запросы после удаления Masya");
        printAllUsersAndQueries();
    }

    public static void addUser(User user) {
        userQueries.putIfAbsent(user, new ArrayList<>());
    }

    public static void addQuery(User user, Query query) {
        userQueries.computeIfAbsent(user, k -> new ArrayList<>()).add(query);
    }

    public static void removeUser(User user) {
        userQueries.remove(user);
    }

    public static void printAllUsersAndQueries() {
        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            User user = entry.getKey();
            List<Query> queries = entry.getValue();
            System.out.println("Пользователь: " + user.getName() + " (ID: " + user.getId() + ")");
            for (Query query : queries) {
                System.out.println("  Query ID: " + query.getId() + ", Content: " + query.getContent());
            }
        }
    }

    public static void printUserQueryHistory(User user) {
        List<Query> queries = userQueries.get(user);
        if (queries == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("История запросов от пользователей: " + user.getName() + " (ID: " + user.getId() + ")");
        queries.sort(Comparator.comparingLong(Query::getTimestamp));
        for (Query query : queries) {
            System.out.println("  Запрос ID: " + query.getId() + ", Content: " + query.getContent() + ", Timestamp: " + query.getTimestamp());
        }
    }
}