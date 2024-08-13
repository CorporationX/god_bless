package faang.school.godbless.BJS2_19839;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<User, List<Query>> userQueries = new HashMap<>();

    public static void main(String[] args) {
        User ivan = new User(1, "Ivan");
        List<Query> ivanQueries = new ArrayList<>();
        ivanQueries.add(new Query(1, "the weather in london", new Timestamp(System.currentTimeMillis())));
        ivanQueries.add(new Query(2, "the distance from Belarus to Australia",
                new Timestamp(System.currentTimeMillis())));
        addUserAndQueries(ivan, ivanQueries);

        User alexsandr = new User(2, "Alexsandr");
        Query alexsandrQuery = new Query(3, "what is the time in Canada",
                new Timestamp(System.currentTimeMillis()));
        userQueries.put(alexsandr, null);
        addQuery(alexsandr, alexsandrQuery);

        printUsers();
        deleteUser(alexsandr);
        printUserQueryHistory(ivan);
    }

    private static void addUserAndQueries(User user, List<Query> queries) {
        userQueries.putIfAbsent(user, queries);
    }

    private static void addQuery(User user, Query query) {
        userQueries.computeIfAbsent(user, queries -> new ArrayList<>()).add(query);
    }

    private static void deleteUser(User user) {
        userQueries.remove(user);
    }

    private static void printUsers() {
        for (var user : userQueries.entrySet()) {
            System.out.println(user.getKey());
            for (var query : user.getValue()) {
                System.out.println(query);
            }
        }
    }

    private static void printUserQueryHistory(User user) {
        if (user != null) {
            System.out.println(user.getName());
            userQueries.get(user).stream()
                    .sorted(Comparator.comparing(Query::getTimestamp))
                    .forEach(System.out::println);
        }
    }

}
