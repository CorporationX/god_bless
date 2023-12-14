package faang.school.godbless.BJS2_712;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

public class Main {
    public static Map<User, List<Query>> requestsByUsers = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User("Donald Trump");
        User user2 = new User("Joseph Biden");

        Query query1 = new Query("Select * from users");
        Query query2 = new Query("Select * from Bootcamp");
        Query query3 = new Query("Drop database FAANG");
        List<Query> queriesForUser1 = List.of(query1, query2, query3);
        addQueries(user1, queriesForUser1);

        Query query4 = new Query("Insert into products values (1, 'Apple')");
        Query query5 = new Query("Insert into products values (2, 'Samsung')");
        Query query6 = new Query("Insert into products values (3, 'SpaceX')");
        addQuery(user2, query4);
        addQuery(user2, query5);
        addQuery(user2, query6);

        printAll();
        printAllByUser(user2);

        removeUserAndQuery(user1);

        System.out.println("\nAfter removing user1:");
        printAll();
    }

    public static void addQueries(User user, List<Query> queries) {
        requestsByUsers.put(user, queries);
    }

    public static void addQuery(User user, Query query) {
        requestsByUsers.computeIfAbsent(user, key -> new ArrayList<>()).add(query);
    }

    public static void removeUserAndQuery(User user) {
        requestsByUsers.remove(user);
    }

    public static void printAll() {
        requestsByUsers.forEach((user, queries) -> {
            System.out.println(user + " Queries: " + queries);
        });
    }

    public static void printAllByUser(User user) {
        List<Query> queries = requestsByUsers.get(user);
        if (queries == null) {
            System.out.println("User not found");
            return;
        }

        queries.sort(Comparator.comparing(query -> query.getTimestamp()));

        System.out.println("Queries for User " + user.getName() + ":");
        queries.forEach(query -> System.out.println(query));
    }
}