package faang.school.godbless.task_15;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<User, List<Query>> USER_QUERIES = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User(1, "Tema");
        User user2 = new User(2, "Valera");
        User user3 = new User(3, "Anya");

        Query query1 = new Query(1, "swipe", LocalDateTime.now());
        Query query2 = new Query(2, "skip", LocalDateTime.now().minusDays(2));
        Query query3 = new Query(3, "tap", LocalDateTime.now().minusDays(10));
        Query query4 = new Query(4, "close up", LocalDateTime.now().plusDays(1));
        Query query5 = new Query(5, "jump", LocalDateTime.now());

        addUser(user1, List.of(query1, query2));
        addUser(user2, List.of(query3, query4));
        addUser(user3, List.of(query5));

        deleteUser(user3);

        printUsers();
    }

    public static void addUser(User user, List<Query> queries) {
        if (USER_QUERIES.containsKey(user)) {
            return;
        }
        USER_QUERIES.put(user, queries);
    }

    public static void addQuery(User user, Query query) {
        if (!USER_QUERIES.containsKey(user)) {
            return;
        }
        USER_QUERIES.get(user).add(query);
    }

    public static void deleteUser(User user) {
        USER_QUERIES.remove(user);
    }

    public static void printUsers() {
        for (User user : USER_QUERIES.keySet()) {
            printQueryHistory(user);
        }
    }

    private static void printQueryHistory(User user) {
        System.out.println(user.getName() + ": ");
        List<Query> sorted = USER_QUERIES.get(user).stream().sorted(Comparator.comparing(Query::getTimestamp)).toList();
        for (Query query : sorted) {
            System.out.println("----" + query.getContent() + " -> " + query.getTimestamp());
        }
    }
}
