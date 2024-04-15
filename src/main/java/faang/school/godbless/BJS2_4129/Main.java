package faang.school.godbless.BJS2_4129;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final Map<User, List<Query>> USER_QUERIES = new HashMap<>();

    public static void main(String[] args) {
        User user = new User(1, "Andrei");
        User guest = new User(1, "Guest");
        List<Query> queries = new ArrayList<>();

        queries.add(new Query(1, "Запрос 1", LocalDateTime.now()));
        addQuery(guest, new Query(1, "Запрос 1", LocalDateTime.now()));
        addUser(user, queries);
        addQuery(user, new Query(2, "Запрос 2", LocalDateTime.now().plusMinutes(1)));
        addQuery(user, new Query(2, "Запрос 3", LocalDateTime.now().minusDays(1)));

        printUsersAndQueries();
        removeUser(guest);
        printUsersAndQueries();
    }

    public static void addUser(User user, List<Query> queries) {
        USER_QUERIES.put(user, queries);
    }

    public static void addQuery(User user, Query query) {
        USER_QUERIES.computeIfAbsent(user, k -> new ArrayList<>()).add(query);
    }

    public static void removeUser(User user) {
        USER_QUERIES.remove(user);
    }

    public static void printUsersAndQueries() {
        for (Map.Entry<User, List<Query>> entry : USER_QUERIES.entrySet()) {
            System.out.println("Пользователь: " + entry.getKey().getName());

            List<Query> sortedQueries = entry.getValue();
            sortedQueries.sort(Comparator.comparing(Query::getTimestamp));

            for (Query query : sortedQueries) {
                System.out.printf(" - %s [\"%s\"]", query.getContent(), query.getTimestamp());
                System.out.println();
            }
        }
    }
}