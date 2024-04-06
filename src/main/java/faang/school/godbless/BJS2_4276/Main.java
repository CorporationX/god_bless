package faang.school.godbless.BJS2_4276;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<User, List<Query>> USER_QUERIES = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {

        User steve = new User( "Steve");
        List<Query> queries = new ArrayList<>();
        queries.add(new Query( "How to fight"));
        queries.add(new Query( "Weather"));

        addNewUserWithQuery(steve, queries);

        addUserWithQuery(steve, List.of(new Query( "LinkedIn")));
        addUserWithQuery(steve, List.of(new Query( "Map")));

        printAllUserQueries();

        printQueries(steve);

        Thread.sleep(2000);
        queries.add( new Query("Harry Potter"));

        printAllUserQueries();

        removeUserWithQueries(steve);

        System.out.println("Remove all");
        printAllUserQueries();
    }

    private static void addNewUserWithQuery(User user, List<Query> queries) {
        USER_QUERIES.put(user, queries);
    }

    private static void addUserWithQuery(User user, List<Query> queries) {
        List<Query> queries1 = USER_QUERIES.getOrDefault(user, new ArrayList<>());
        queries1.addAll(queries);
        USER_QUERIES.put(user, queries1);
    }

    private static void removeUserWithQueries(User user) {
        USER_QUERIES.remove(user);
    }

    private static void printAllUserQueries() {
        if (!USER_QUERIES.isEmpty()) {
            for (var entry : USER_QUERIES.entrySet()) {
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
        if (USER_QUERIES.containsKey(user)) {
            USER_QUERIES.get(user).stream()
                    .sorted(Comparator.comparing(Query::getTimestamp))
                    .forEach(System.out::println);
        } else System.err.println(user.getName() + " Queries not found");
    }
}
