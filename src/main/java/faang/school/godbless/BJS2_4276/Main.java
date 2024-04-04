package faang.school.godbless.BJS2_4276;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<User, List<Query>> userQueries = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {

        User steve = new User(1L, "Steve");
        List<Query> queries = new ArrayList<>();
        queries.add(new Query(1L, "How to fight", LocalDateTime.now()));
        queries.add(new Query(2L, "Weather", LocalDateTime.now()));

        addNewUserWithQuery(steve, queries);

        addUserWithQuery(steve, List.of(new Query(3L, "LinkedIn", LocalDateTime.now())));
        addUserWithQuery(steve, List.of(new Query(4L, "Map", LocalDateTime.now())));

        printAllUserQueries();

        printQueries(steve);

        Thread.sleep(2000);
        queries.add(new Query(5L, "Harry Potter", LocalDateTime.now()));

        printAllUserQueries();

        removeUserWithQueries(steve);

        System.out.println("Remove all");
        printAllUserQueries();
    }

    private static void addNewUserWithQuery(User user, List<Query> queries) {
        userQueries.put(user, queries);
    }

    private static void addUserWithQuery(User user, List<Query> queries) {
        List<Query> queries1 = userQueries.getOrDefault(user, new ArrayList<>());
        queries1.addAll(queries);
        userQueries.put(user, queries1);
    }

    private static void removeUserWithQueries(User user) {
        userQueries.remove(user);
    }

    private static void printAllUserQueries() {
        if (!userQueries.isEmpty()) {
            for (var entry : userQueries.entrySet()) {
                System.out.println(entry.getKey().getName());
                if (!entry.getValue().isEmpty()) {
                    entry.getValue().stream()
                            .sorted(Comparator.comparing(Query::getTimestamp))
                            .forEach(System.out::println);
                }
            }
        }
    }

    private static void printQueries(User user) {
        if (userQueries.containsKey(user)) {
            userQueries.get(user).stream()
                    .sorted(Comparator.comparing(Query::getTimestamp))
                    .forEach(System.out::println);
        } else System.err.println(user.getName() + " Queries not found");
    }

}
