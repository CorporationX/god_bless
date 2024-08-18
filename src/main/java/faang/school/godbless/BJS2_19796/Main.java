package faang.school.godbless.BJS2_19796;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<User, List<Query>> userQueries = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User("Sasha");
        User user2 = new User("Lesha");
        User user3 = new User("Ktoto");

        addUser(user1, new ArrayList<>(List.of(
                new Query("videos"),
                new Query("youtube shorts"),
                new Query("tiktok")
        )));
        addUser(user2, new ArrayList<>(List.of(
                new Query("vk"),
                new Query("instagram")
        )));
        addUser(user3, new ArrayList<>(List.of(
                new Query("useless query"),
                new Query("how to feed a penguin")
        )));

        printAllUserQueries();
        System.out.println();

        addQuery(user3, new Query("how to produce dynamite from a soap"));

        printAllUserQueries();
        System.out.println();

        deleteUser(user1);

        printUserQueries(user3);

    }

    private static void addUser(User user, List<Query> queries) {
        if (!userQueries.containsKey(user)) {
            userQueries.put(user, queries);
        } else {
            System.out.println("User " + user + " already exists, user was not added");
        }
    }

    private static void addQuery(User user, Query query) {
        userQueries.computeIfAbsent(user, k -> new ArrayList<>()).add(query);
    }

    private static void deleteUser(User user) {
        if (userQueries.containsKey(user)) {
            userQueries.remove(user);
        } else {
            System.out.println("User " + user + " does not exist. User was not deleted");
        }
    }

    // В задании написано сделать цикл через мап ентри но по моему тут это не имеет смысла
    private static void printUserQueries(User user) {
        if (!userQueries.containsKey(user)) throw new IllegalArgumentException("User " + user + " does not exist");

        List<Query> sortedQueries = userQueries.get(user);
        sortedQueries.sort(Query::compareTo);

        System.out.println(user.getName() + " queries: ---------");

        sortedQueries.forEach(q -> System.out.println("  - " + q.toString()));
    }

    private static void printAllUserQueries() {
        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(q -> System.out.println("  - " + q.toString()));
        }
    }
}
