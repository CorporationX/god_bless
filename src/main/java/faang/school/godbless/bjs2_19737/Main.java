package faang.school.godbless.bjs2_19737;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static java.util.Comparator.comparing;

public class Main {
    private static Map<User, LinkedList<Query>> userQueries;

    public static void main(String[] args) {
        userQueries = new HashMap<>();

        var user = new User(1, "John");
        var query1 = new Query(1, "oldest query");
        var query2 = new Query(2, "query2");
        var query3 = new Query(3, "query3");
        var queries = new LinkedList<Query>();
        queries.addFirst(query1);
        queries.addFirst(query2);
        queries.addFirst(query3);

        addUserWithQueries(user, queries);
        print(user);

        var newQuery = new Query(4, "newest query");
        addQueryToUser(newQuery, user);
        print(user);
    }

    private static void addUserWithQueries(User user, LinkedList<Query> queries) {
        userQueries.computeIfAbsent(user, q -> new LinkedList<>()).addAll(0, queries);
    }

    private static void addQueryToUser(Query query, User user) {
        userQueries.computeIfAbsent(user, q -> new LinkedList<>()).addFirst(query);
    }

    private static void deleteUser(User user) {
        userQueries.remove(user);
    }

    private static void print(User user) {
        printData();
        System.out.println("----");
        printUserQueries(user);
        System.out.println("----------------");
    }

    private static void printData() {
        for (Map.Entry<User, LinkedList<Query>> entry : userQueries.entrySet()) {
            System.out.println("User: " + entry.getKey().getName());
            printQueries(entry.getValue());
        }
    }

    // from new to older
    private static void printQueries(LinkedList<Query> queries) {
        queries.forEach(query -> System.out.println("    " + query.toString()));
    }

    // from older (earlier queries) to new one
    private static void printUserQueries(User user) {
        for (Map.Entry<User, LinkedList<Query>> entry : userQueries.entrySet()) {
            System.out.println("User: " + entry.getKey().getName());
            var queries = entry.getValue();
            // don't know to sort and print without changing current List
            var queriesToSort = new LinkedList<>(queries);
            queriesToSort.sort(comparing(Query::getTimestamp));
            printQueries(queriesToSort);
        }
    }
}
