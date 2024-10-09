package school.faang.ELK;

import java.util.*;

public class Main {
    private static final Map<User, List<Query>> users = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User(1, "User1");
        User user2 = new User(2, "User2");
        User user3 = new User(3, "User3");

        Query query1 = new Query(1, "Some Content");
        Query query2 = new Query(2, "Some Content");
        Query query3 = new Query(3, "Some Content");

        addUser(user1, new ArrayList<>(List.of(query1, query2)));
        addUser(user2, new ArrayList<>(List.of(query2, query3)));
        addUser(user3, new ArrayList<>(List.of(query1, query3)));

        printUsers();

        addQueryToUser(user1, query3);
        removeUser(user2);

        printUsers();
    }

    public static void addUser(User user, List<Query> queries) {
        users.put(user, queries);
    }

    public static void addQueryToUser(User user, Query query) {
        users.get(user).add(query);
    }

    public static void removeUser(User user) {
        users.remove(user);
    }

    public static void printUsers() {
        users.forEach((user, queries) -> {
            System.out.println(user + ": ");
            queries.stream().sorted(Comparator.comparing(Query::getTimestamp)).
                    forEach(System.out::println);
        });
    }
}