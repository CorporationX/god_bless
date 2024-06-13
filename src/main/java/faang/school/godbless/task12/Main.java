package faang.school.godbless.task12;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static Map<User, List<Query>> userQueries = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User(1, "Alice");
        User user2 = new User(2, "Bob");

        Query query1 = new Query(1, "Hello", LocalDateTime.now());
        Query query2 = new Query(2, "World", LocalDateTime.now().minusHours(1));

        addNewQueries(user1, new ArrayList<>(Collections.singletonList(query1)));
        addNewQueries(user2, new ArrayList<>(Collections.singletonList(query2)));

        addNewQuery(user1, new Query(3, "How are you?", LocalDateTime.now().minusMinutes(30)));

        printQueries(user1);
        printAllUsersAndQueries();

    }

    public static void addNewQueries(User user, List<Query> queries) {
        if (userQueries.containsKey(user)) {
            for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
                if (entry.getKey().equals(user)) {
                    entry.getValue().addAll(queries);
                }
            }
        } else userQueries.put(user, queries);
    }

    public static void addNewQuery(User user, Query queries) {
        addNewQueries(user, new ArrayList<>(List.of(queries)));
    }

    public static void printQueries(User user) {
        if (userQueries.containsKey(user)) {
            for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
                if (entry.getKey().equals(user)) {
                    entry.getValue().stream().sorted((x, y) -> y.getDate().compareTo(x.getDate())).forEach(System.out::println);
                }
            }
        }
    }

    public static void removeUser(User user) {
        userQueries.remove(user);
    }

    public static void printAllUsersAndQueries() {
        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            User user = entry.getKey();
            List<Query> queries = entry.getValue();
            System.out.println("User: " + user.getName());
            for (Query query : queries) {
                System.out.println("Query ID: " + query.getId() + ", Content: " + query.getContent() + ", Timestamp: " + query.getDate());
            }
        }
    }
}
