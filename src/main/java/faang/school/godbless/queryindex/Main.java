package faang.school.godbless.queryindex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<User, List<Query>> usersAndQueries = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        addUser(user1);
        addUser(user2);

        addQueryToUser(user1, new Query("What is the weather today?"));
        addQueryToUser(user1, new Query("What is the meaning of life?"));
        addQueryToUser(user1, new Query("How to cook pasta?"));
        addQueryToUser(user2, new Query("Best programming languages in 2024"));
        addQueryToUser(user2, new Query("Who will be the President of the USA?"));

        System.out.println("All users and their queries:");
        printAllUsersAndQueries();

        System.out.println("\nRemoving Bob...");
        removeUser(user2);

        System.out.println("\nAll users and their queries after removing Bob:");
        printAllUsersAndQueries();

        System.out.println("\nQuery history for user: " + user1.getName());
        printUserQueryHistory(user1);
    }

    public static void addUser(User user) {
        usersAndQueries.putIfAbsent(user, new ArrayList<>());
    }

    public static void addQueryToUser(User user, Query query) {
        usersAndQueries.get(user).add(query);
    }

    public static void removeUser(User user) {
        usersAndQueries.remove(user);
    }

    public static void printAllUsersAndQueries() {
        for (Map.Entry<User, List<Query>> entry : usersAndQueries.entrySet()) {
            System.out.println(entry.getKey());
            for (Query query : entry.getValue()) {
                System.out.println("  " + query);
            }
        }
    }

    public static void printUserQueryHistory(User user) {
        List<Query> queries = usersAndQueries.get(user);
        if (queries != null) {
            queries.stream()
                    .sorted(Comparator.comparing(Query::getTimestamp))
                    .forEach(System.out::println);
        } else {
            System.out.println("No queries found for user: " + user.getName());
        }
    }
}
