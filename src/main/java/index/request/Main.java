package index.request;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<User, List<Query>> userQueryMap = new HashMap<>();

        addUser(userQueryMap, new User(1, "James"));
        addQuery(userQueryMap, new User(1, "James"), new Query(1, "Query1", System.currentTimeMillis()));
        addQuery(userQueryMap, new User(1, "James"), new Query(2, "Query2", System.currentTimeMillis() + 1000));

        addUser(userQueryMap, new User(2, "Allison"));
        addQuery(userQueryMap, new User(2, "Allison"), new Query(3, "Query3", System.currentTimeMillis() + 200000));

        addUser(userQueryMap, new User(3, "Gregory"));
        addQuery(userQueryMap, new User(3, "Gregory"), new Query(4, "Query4", System.currentTimeMillis() + 300000));
        addQuery(userQueryMap, new User(3, "Gregory"), new Query(5, "Query5", System.currentTimeMillis() + 500));

        printUserQueries(userQueryMap);

        removeUser(userQueryMap, new User(1, "James"));

        printUserQueries(userQueryMap);
    }

    private static void addUser(Map<User, List<Query>> userQueryMap, User user) {
        userQueryMap.putIfAbsent(user, new ArrayList<>());
    }

    private static void addQuery(Map<User, List<Query>> userQueryMap, User user, Query query) {
        userQueryMap.computeIfAbsent(user, k -> new ArrayList<>()).add(query);
    }

    private static void removeUser(Map<User, List<Query>> userQueryMap, User user) {
        userQueryMap.remove(user);
        System.out.println("Deleted the user " + user.getName() + "\n");
    }

    private static void printUserQueries(Map<User, List<Query>> userQueryMap) {
        System.out.println("All queries: ");
        for (Map.Entry<User, List<Query>> entry : userQueryMap.entrySet()) {
            User user = entry.getKey();
            List<Query> queries = entry.getValue();

            System.out.println("User: " + user.getName());
            System.out.println("Queries:");

            queries.sort(Comparator.comparingLong(Query::getTimestamp));

            for (Query query : queries) {
                System.out.println("  Query ID: " + query.getId() +
                        ", Content: " + query.getContent() +
                        ", Timestamp: " + query.getTimestamp());
            }

            System.out.println();
        }
    }
}
