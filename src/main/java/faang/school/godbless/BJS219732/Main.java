package faang.school.godbless.BJS219732;

import java.util.*;

public class Main {
    private static Map<User, List<Query>> userQueries = new HashMap<>();

    public static void addUserAndQueries(User user, List<Query> queries) {
        userQueries.put(user, queries);
    }

    public static void addQuery(User user, Query query) {
        List<Query> queries = userQueries.get(user);
        if (queries != null) {
            queries.add(query);
        } else {
            System.out.println("User not found: " + user.getName());
        }
    }

    public static void removeUserAndQueries(User user) {
        if (userQueries.containsKey(user)) {
            userQueries.remove(user);
        } else {
            System.out.println("User not found: " + user.getName());
        }
    }

    public static void clearQueriesByUser(User user) {
        List<Query> queries = userQueries.get(user);
        if (queries != null) {
            queries.clear();
        } else {
            System.out.println("User not found: " + user.getName());
        }
    }

    public static void printUserAndQueries() {
        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            System.out.println(entry.getKey().toString() + ":");
            for (Query query : entry.getValue()) {
                System.out.println("-" + query.toString());
            }
        }
    }

    public static void printUserHistory(User user) {
        List<Query> queries = userQueries.get(user);
        if (queries != null) {
            queries.sort(Comparator.comparingLong(Query::getTimestamp));
            for (Query query : queries) {
                System.out.println(query.toString());
            }
        } else {
            System.out.println("User not found: " + user.getName());
        }
    }

    public static void main(String[] args) {
        User user1 = new User(1, "Alice");
        User user2 = new User(2, "Bob");

        Query query1 = new Query(1, "How to learn Java?", System.currentTimeMillis());
        Query query2 = new Query(2, "Java HashMap tutorial", System.currentTimeMillis());
        Query query3 = new Query(3, "Best practices in Java", System.currentTimeMillis());

        addUserAndQueries(user1, new ArrayList<>(Arrays.asList(query1)));
        addQuery(user1, query2);

        addUserAndQueries(user2, new ArrayList<>(Arrays.asList(query3)));

        printUserAndQueries();

        System.out.println("\nHistory of queries for user " + user1.getName() + ":");
        printUserHistory(user1);
    }
}
