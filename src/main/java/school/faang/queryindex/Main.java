package school.faang.queryindex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private Map<User, List<Query>> userQueries = new HashMap<>();

    // Add a new user with an empty list of queries
    public void addUser(User user) {
        if (!userQueries.containsKey(user)) {
            userQueries.put(user, new ArrayList<>());
        }
    }

    // Remove a user and their list of queries
    public void removeUser(User user) {
        userQueries.remove(user);
    }

    // Add a new query for an existing user
    public void addQuery(User user, Query query) {
        List<Query> queries = userQueries.get(user);
        if (queries != null) {
            queries.add(query);
        } else {
            System.out.println("User does not exist.");
        }
    }

    // Display all users and their queries
    public void displayAllUsersAndQueries() {
        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            System.out.println("User: " + entry.getKey().getName());
            for (Query query : entry.getValue()) {
                System.out.println(" - Query: " + query.getContent() + " (Timestamp: " + query.getTimestamp() + ")");
            }
        }
    }

    // Display query history for a specific user sorted by timestamp
    public void displayUserQueryHistory(User user) {
        List<Query> queries = userQueries.get(user);
        if (queries != null) {
            queries.sort(Comparator.comparing(Query::getTimestamp));
            System.out.println("Query History for User: " + user.getName());
            for (Query query : queries) {
                System.out.println(" - Query: " + query.getContent() + " (Timestamp: " + query.getTimestamp() + ")");
            }
        } else {
            System.out.println("User does not exist or has no queries.");
        }
    }
    public static void main(String[] args) {
        Main mainApp = new Main();

        User user1 = new User(1, "Alice");
        User user2 = new User(2, "Bob");

        mainApp.addUser(user1);
        mainApp.addUser(user2);

        Query query1 = new Query(1, "What is the weather today?", LocalDateTime.now().minusHours(2));
        Query query2 = new Query(2, "How to learn Java?", LocalDateTime.now().minusHours(1));

        mainApp.addQuery(user1, query1);
        mainApp.addQuery(user1, query2);

        mainApp.displayAllUsersAndQueries();
        mainApp.displayUserQueryHistory(user1);
    }
}