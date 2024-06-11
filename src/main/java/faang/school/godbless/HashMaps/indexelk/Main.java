package faang.school.godbless.HashMaps.indexelk;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<User, List<Query>> userQueries = new HashMap<>();

    public static void main(String[] args) {
        addUserQueries(
                new User(1, "Саша"),
                new ArrayList<>(List.of(
                        new Query(1, "java basic", new Timestamp(System.currentTimeMillis())),
                        new Query(2, "java collections", new Timestamp(System.currentTimeMillis())),
                        new Query(3, "Stream API", new Timestamp(System.currentTimeMillis()))
                ))
        );
        addUserQueries(
                new User(2, "Петя"),
                new ArrayList<>(List.of(
                        new Query(4, "Java Set", new Timestamp(System.currentTimeMillis())),
                        new Query(5, "Java Map", new Timestamp(System.currentTimeMillis()))
                ))
        );
        showAllUserQueries();

        System.out.println("Добавление запроса пользователю");
        addQueryForUser(
                new User(1, "Саша"),
                new Query(6, "SQL", new Timestamp(System.currentTimeMillis()))
        );
        showAllUserQueries();

        System.out.println("Удаление истории запросов пользователя");
        removeUserQueries(new User(2, "Петя"));
        showAllUserQueries();
    }

    public static void addUserQueries(User user, List<Query> queries) {
        userQueries.put(user, queries);
    }

    public static void addQueryForUser(User user, Query query) {
        userQueries.get(user).add(query);
    }

    public static void removeUserQueries(User user) {
        userQueries.remove(user);
    }

    public static void showAllUserQueries() {
        System.out.println("Вывод всех пользователей и их запросов");
        for (Map.Entry<User, List<Query>> userQueriesEntry : userQueries.entrySet()) {
            System.out.println("\t" + "Пользователь: " + userQueriesEntry.getKey());
            showHistoryUserQueries(userQueriesEntry.getKey());
            System.out.println();
        }
    }

    public static void showHistoryUserQueries(User user) {
        List<Query> queries = userQueries.get(user);
        queries.sort(new Comparator<Query>() {
            @Override
            public int compare(Query o1, Query o2) {
                return Long.compare(o1.timestamp().getTime(), o2.timestamp().getTime());
            }
        });

        for (Query query : queries) {
            System.out.println("\t".repeat(2) + query);
        }
    }
}
