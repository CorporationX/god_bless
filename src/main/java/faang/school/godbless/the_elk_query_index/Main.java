package faang.school.godbless.the_elk_query_index;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Main {
    private static final Map<User, List<Query>> queryStack = new HashMap<>();

    public static void main(String[] args) {
        User user = new User(UUID.randomUUID(), "John");
        User removedUser = new User(UUID.randomUUID(), "Jane");

        addUserAndQuery(
                user,
                new Query(UUID.randomUUID(), "Hello", 1338957423)
        );
        printAllUsersWithQueries();

        addQuery(user, new Query(UUID.randomUUID(), "World", 1338957421));
        printAllUsersWithQueries();

        addUserAndQuery(
                removedUser,
                new Query(UUID.randomUUID(), "Test", 1338957444)
        );
        printAllUsersWithQueries();

        removeQuery(removedUser);
        printAllUsersWithQueries();

        addUserAndQuery(
                removedUser,
                new Query(UUID.randomUUID(), "Hello", 1338957423)
        );
        addQuery(user, new Query(UUID.randomUUID(), "test", 1333957444));
        addQuery(removedUser, new Query(UUID.randomUUID(), "test", 1333957422));
        printHistory();
    }

    public static void addUserAndQuery(User user, Query query) {
        queryStack.computeIfAbsent(user, k -> new ArrayList<>()).add(query);
    }

    public static void addQuery(User user, Query query) {
        queryStack.get(user).add(query);
    }

    public static void removeQuery(User user) {
        queryStack.remove(user);
    }

    public static void printAllUsersWithQueries() {
        queryStack.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println();
    }

    public static void printHistory() {
        for (Map.Entry<User, List<Query>> entry : queryStack.entrySet()) {
            System.out.println(entry.getKey().getName());
            entry.getValue().sort(Comparator.comparingInt(Query::getTimestamp));
            for (Query query : entry.getValue()) {
                System.out.println(query);
            }
        }
    }
}
