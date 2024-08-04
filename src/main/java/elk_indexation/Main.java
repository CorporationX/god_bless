package elk_indexation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final HashMap<User, List<Query>> userQueries = new HashMap<>();

    public static void main(String[] args) {
        int userIdCounter = 0;
        int queryIdCounter = 0;
        User user1 = new User(userIdCounter++, "Vitaly");
        User user2 = new User(userIdCounter++, "Michael");

        addUserQueries(user1, new ArrayList<>());
        addUserQueries(user2, new ArrayList<>());

        addQueryToUserQueries(user1, new Query(queryIdCounter++, "query1", LocalTime.now()));
        addQueryToUserQueries(user1, new Query(queryIdCounter++, "query2", LocalTime.now()));
        addQueryToUserQueries(user1, new Query(queryIdCounter++, "query3", LocalTime.now()));
        addQueryToUserQueries(user2, new Query(queryIdCounter++, "query1", LocalTime.now()));
        addQueryToUserQueries(user2, new Query(queryIdCounter++, "query2", LocalTime.now()));

        printUserQueries();

        printUserQueriesByTimestamp();
        deleteUserQueries(user2);
        printUserQueriesByTimestamp();
    }

    public static void addUserQueries(User user, List<Query> queries) {
        userQueries.put(user, queries);
    }

    public static void addQueryToUserQueries(User user, Query query) {
        List<Query> queries = new ArrayList<>(userQueries.get(user));
        queries.add(query);
        userQueries.put(user, queries);
    }

    public static void deleteUserQueries(User user) {
        userQueries.remove(user);
    }

    public static void printUserQueries() {
        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            System.out.printf("Запросы пользователя %s : %s%n",
                    entry.getKey().getName(), entry.getValue());
        }
    }

    public static void printUserQueriesByTimestamp() {
        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            List<Query> queries = entry.getValue();
            queries.sort(Comparator.comparing(Query::getTimestamp).reversed());
            int i = 0;
            System.out.printf("Запросы пользователя %s по времени:%n", entry.getKey().getName());
            for (Query query : queries) {
                System.out.printf("%d. %s%n", ++i, query);
            }
        }
    }

}
