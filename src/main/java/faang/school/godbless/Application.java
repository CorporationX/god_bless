package faang.school.godbless;

import java.util.*;

public class Application {
    private HashMap<User, List<Query>> userQueries = new HashMap<>();

    public void addUser(User user) {
        userQueries.putIfAbsent(user, new ArrayList<>());
        System.out.println("Added user: " + user.getName());
    }

    public void addQuery(User user, Query query) {
        List<Query> queries = userQueries.get(user);
        if (queries != null) {
            queries.add(query);
            System.out.println("Added query for user: " + user.getName());
        } else {
            System.out.println("User not found: " + user.getName());
        }
    }

    public void removeUser(User user) {
        if (userQueries.remove(user) != null) {
            System.out.println("Removed user: " + user.getName());
        } else {
            System.out.println("User not found: " + user.getName());
        }
    }

    public void printAllUsersAndQueries() {
        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            User user = entry.getKey();
            List<Query> queries = entry.getValue();
            System.out.println(user.getName() + "'s queries:");
            for (Query query : queries) {
                System.out.println("\t" + query);
            }
        }
    }

    public void printUserQueryHistory(User user) {
        List<Query> queries = userQueries.get(user);
        if (queries != null) {
            queries.sort(Comparator.comparing(Query::getTimestamp));
            System.out.println(user.getName() + "'s sorted queries:");
            for (Query query : queries) {
                System.out.println("\t" + query);
            }
        } else {
            System.out.println("User not found!");
        }
    }
    public static void main(String[] args) {
        Application app = new  Application();

        User user1 = new User(1, "Alice");
        User user2 = new User(2, "Bob");

        app.addUser(user1);
        app.addUser(user2);

        Query query1 = new Query(1, "Hi", new Date());
        Query query2 = new Query(2, "Hi", new Date());
        Query query3 = new Query(3, "Bey", new Date());

        app.addQuery(user1, query1);
        app.addQuery(user1, query2);
        app.addQuery(user2, query3);

        app.printAllUsersAndQueries();

        app.printUserQueryHistory(user1);

        app.removeUser(user1);

        app.printAllUsersAndQueries();

    }
}
