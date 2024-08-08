package index.elk;

import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    @Getter
    private static final Map<User, List<Query>> userQueries = new HashMap<>();
    @Getter
    private static final Map<Integer, Integer> queriesIndex = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User("Vita");
        User user2 = new User("Kolya");
        User user3 = new User("Vika");
        List<Query> queries1 = new ArrayList<>(
                List.of(
                        new Query("aboba", getRandomDateTime()),
                        new Query("abiba", getRandomDateTime()),
                        new Query("abuba", getRandomDateTime())
                )
        );
        List<Query> queries2 = new ArrayList<>(
                List.of(
                        new Query("oboba", getRandomDateTime()),
                        new Query("obiba", getRandomDateTime()),
                        new Query("obuba", getRandomDateTime())
                )
        );
        List<Query> queries3 = new ArrayList<>(
                List.of(
                        new Query("uboba", getRandomDateTime()),
                        new Query("ubiba", getRandomDateTime()),
                        new Query("ububa", getRandomDateTime())
                )
        );
        addNewUser(user1, queries1);
        addNewUser(user2, queries2);
        addNewUser(user3, queries3);
        printAllQueries();
        addNewUser(user1, queries1);
        addNewUser(new User("Vlad"), new ArrayList<>());
        Query newQuery = new Query("ebuba", getRandomDateTime());
        printAllQueries();
        addQueryForUser(user1, newQuery);
        addQueryForUser(user2, newQuery);
        addQueryForUser(new User("Dadya Bob"), new Query("iboba", getRandomDateTime()));
        printAllQueries();
        removeUser(user3);
        removeUser(new User("Petya"));
        printAllQueries();
        printUserQueriesOrdered(user2);
        printUserQueriesOrdered(new User("Leha"));
    }

    public static void addNewUser(@NonNull User user, @NonNull List<Query> queries) {
        if (userQueries.containsKey(user)) {
            System.out.println("\nThis user is already added");
        } else {
            if (!queries.isEmpty()) {
                userQueries.put(user, queries);
                queries.forEach(q -> queriesIndex.put(q.getId(), user.getId()));
            } else {
                System.out.println("\nThis user has not queries!");
            }
        }
    }

    public static void addQueryForUser(@NonNull User user, @NonNull Query query) {
        if (userQueries.containsKey(user)) {
            if (!queriesIndex.containsKey(query.getId())) {
                userQueries.get(user).add(query);
                queriesIndex.put(query.getId(), user.getId());
            } else {
                System.out.println("\nThis query is already in index");
            }
        } else {
            System.out.println("\nThis user not in index");
        }
    }

    public static void removeUser(@NonNull User user) {
        if (userQueries.containsKey(user)) {
            userQueries.get(user).forEach(q -> queriesIndex.remove(q.getId()));
            userQueries.remove(user);
            System.out.println("\nUser queries deleted from index");
        } else {
            System.out.println("\nThis user not in index");
        }
    }

    public static void printAllQueries() {
        System.out.println();
        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            System.out.println(entry.getKey());
            for (Query query : entry.getValue()) {
                System.out.println("    " + query);
            }
        }
    }

    public static void printUserQueriesOrdered(@NonNull User user) {
        if (userQueries.containsKey(user)) {
            System.out.println("\n" + user);
            userQueries.get(user).stream()
                    .sorted(
                            Comparator.comparing(Query::getTimestamp)
                    ).forEach(query -> System.out.println("    " + query));
        } else {
            System.out.println("\nThis user not in index");
        }
    }

    private static LocalDateTime getRandomDateTime() {
        Random rand = new Random();
        return LocalDateTime.now().minusSeconds(rand.nextInt(
                10 * 24 * 60 * 60
        ));
    }
}
