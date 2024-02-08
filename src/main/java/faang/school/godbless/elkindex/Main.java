package faang.school.godbless.elkindex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<User, List<Query>> queries = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User(1, "John");
        User user2 = new User(2, "Alice");

        Query query1 = new Query(1, "Query 1 content", System.currentTimeMillis());
        Query query2 = new Query(2, "Query 2 content", System.currentTimeMillis());

        List<Query> firstQueries = new ArrayList<>();
        firstQueries.add(query1);

        List<Query> secondQueries = new ArrayList<>();
        firstQueries.add(query2);

        addUser(user1, firstQueries);
        addUser(user2, secondQueries);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        addQuery(user1, new Query(3, "Query 3 content", System.currentTimeMillis()));
        addQuery(user2, new Query(4, "Query 4 content", System.currentTimeMillis()));

        System.out.println("All Users and Queries:");
        printUsers();

        System.out.println("\nUser Queries:");
        userQueries(user1);

        deleteUser(user1);

        System.out.println("\nAfter Deleting User:");
        printUsers();
    }

    public static void addUser(User user, List<Query> userQueries) {
        queries.putIfAbsent(user, userQueries);
    }

    public static void addQuery(User user, Query query) {
        List<Query> userQueries = queries.get(user);
        if (userQueries != null && !userQueries.contains(query)) {
            userQueries.add(query);
        }
    }

    public static void deleteUser(User user) {
        queries.remove(user);
    }

    public static void printUsers() {
        for (var entry : queries.entrySet()) {
            if (entry.getKey() != null) {
                System.out.println(entry.getKey().getName() + " queries: ");
                for (var query : entry.getValue()) {
                    if (query != null) {
                        System.out.println(query);
                    }
                    else {
                        System.out.println("Error: query is null");
                    }
                }
            }
            else {
                System.out.println("Error: user is null");
            }
            System.out.println();
        }
    }

    public static void userQueries(User user) {
        System.out.println("User: " + user.getName());
        List<Query> userQueries = queries.get(user);
        if (userQueries != null) {
            userQueries.stream().sorted().forEach(System.out::println);
        }
    }
}