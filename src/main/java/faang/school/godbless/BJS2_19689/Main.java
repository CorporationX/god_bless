package faang.school.godbless.BJS2_19689;

import java.time.LocalTime;
import java.util.*;

public class Main {

    private static Map<User, List<Query>> queriesByUser = new HashMap<>();

    public static void main(String[] args) {
        User anton = new User(1, "Anton");
        User gosha = new User(1, "Gosha");

        List<Query> antonQueries = new ArrayList<>();
        antonQueries.add(new Query(1, "asd", new Date()));
        antonQueries.add(new Query(2, "dasdadas", new Date()));

        List<Query> goshaQueries = new ArrayList<>();
        goshaQueries.add(new Query(1, "gosha", new Date()));
        goshaQueries.add(new Query(2, "goshaaaa", new Date()));

        addUserAndQueries(anton, antonQueries);
        addUserAndQueries(gosha, goshaQueries);
        addQueryToUser(gosha, new Query(3, "3rd", new Date()));
        deleteUser(anton);
        printInfo();
    }

    public static void addUserAndQueries(User user, List<Query> queries) {
        queriesByUser.put(user, queries);
    }

    public static void addQueryToUser(User user, Query query) {
        queriesByUser.computeIfAbsent(user, x -> new ArrayList<>()).add(query);
    }

    public static void deleteUser(User user) {
        queriesByUser.remove(user);
    }

    public static void printInfo() {
        queriesByUser.forEach((user, queries) -> {
            queries.sort(Comparator.comparing(Query::timestamp));
            System.out.println(user.name() + ": " + queries);
        });
    }
}
