package queryIndex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<User, List<Query>> USER_QUERIES = new HashMap<>();

    private static String stringFormat(String user, String query) {
        return """
                Пользователь: %s
                Запросы: %s
                """.formatted(user, query);
    }

    public static void addToUserQueries(User user, List<Query> queries) {
        USER_QUERIES.putIfAbsent(user, queries);
    }

    public static void addNewQuery(User user, Query query) {
        USER_QUERIES.get(user).add(query);
    }

    public static void deleteUser(User user) {
        USER_QUERIES.remove(user);
    }

    public static void printUserQueries() {
        USER_QUERIES.forEach((user, queries) -> {
            System.out.println(stringFormat(user.toString(), queries.toString()));
        });
    }

    public static void printSortedQueries() {
        for (Map.Entry<User, List<Query>> entry : USER_QUERIES.entrySet()) {
            List<Query> queries = entry.getValue();
            queries.sort(Comparator.comparing(Query::getTimestamp));
            System.out.println(stringFormat(entry.getKey().getName(), queries.toString()));
        }
    }

    public static void main(String[] args) {
        User user1 = new User(1, "Alice");
        User user2 = new User(2, "Bob");
        User user3 = new User(3, "Charlie");

        List<Query> aliceQueries = new ArrayList<>();
        aliceQueries.add(new Query(1, "What is Java?", LocalDateTime.of(2023, 10, 1, 10, 0)));
        aliceQueries.add(new Query(2, "Java streams", LocalDateTime.of(2023, 10, 1, 9, 30)));

        List<Query> bobQueries = new ArrayList<>();
        bobQueries.add(new Query(3, "Sorting algorithms", LocalDateTime.of(2023, 10, 1, 11, 0)));
        bobQueries.add(new Query(4, "Data structures", LocalDateTime.of(2023, 10, 1, 10, 15)));

        List<Query> charlieQueries = new ArrayList<>();
        charlieQueries.add(new Query(5, "Sorting algorithms", LocalDateTime.of(2023, 10, 1, 12, 0)));
        charlieQueries.add(new Query(6, "Data structures", LocalDateTime.of(2022, 10, 1, 13, 0)));

        addToUserQueries(user1, aliceQueries);
        addToUserQueries(user2, bobQueries);
        addToUserQueries(user3, charlieQueries);
        printUserQueries();

        addNewQuery(user1, new Query(6, "Data structures", LocalDateTime.of(2023, 10, 1, 13, 0)));
        printUserQueries();

        printSortedQueries();

        deleteUser(user1);
        deleteUser(user2);
        printUserQueries();
    }
}
