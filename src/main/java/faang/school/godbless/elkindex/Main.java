package faang.school.godbless.elkindex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<User, List<Query>> USER_QUERIES = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User("John");
        User user2 = new User("Petr");
        User user3 = new User("Alina");

        Query query1 = new Query("dogs", LocalDateTime.now());
        Query query2 = new Query("cats", LocalDateTime.now().minusDays(2));
        Query query5 = new Query("dollar", LocalDateTime.now());
        Query query6 = new Query("EURO", LocalDateTime.now());

        addUser(user1, List.of(query1, query2));
        addUser(user2, new ArrayList<>());
        addUser(user3, List.of(query5));

        removeUser(user1);

        addQuery(user2, query6);

        printAllUserInfo();

        printUserQueryHistory(user2);
    }

    public static void addUser(User user, List<Query> queries) {
        if (USER_QUERIES.containsKey(user)) {
            throw new IllegalArgumentException("This user already exists");
        }
        USER_QUERIES.put(user, queries);
    }

    public static void addQuery(User user, Query query) {
        if (!USER_QUERIES.containsKey(user)) {
            throw new IllegalArgumentException("This user: " + user + " no such in the index");
        }
        USER_QUERIES.get(user).add(query);
    }

    public static void removeUser(User user) {
        USER_QUERIES.remove(user);
    }

    public static void printAllUserInfo() {
        for (Map.Entry<User, List<Query>> entry : USER_QUERIES.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }

    public static void printUserQueryHistory(User user) {
        System.out.println(user + " history: ");
        List<Query> sortedQueries = USER_QUERIES.get(user).stream()
                .sorted(Comparator.comparing(Query::getTimestamp))
                .toList();
        sortedQueries.forEach(query ->
                System.out.println("Content: " + query.getContent() + " date: " + query.getTimestamp()));
    }


}
