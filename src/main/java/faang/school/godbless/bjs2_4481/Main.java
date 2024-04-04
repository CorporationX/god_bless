package faang.school.godbless.bjs2_4481;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<User, List<Query>> queryUserMap = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User(1, "Ivan");
        List<Query> queryList1 = new ArrayList<>();
        queryList1.add(new Query(1, "Java", LocalDateTime.of(2019, 3, 28, 14, 33, 48)));
        queryList1.add(new Query(2, "Python", LocalDateTime.of(2019, 3, 28, 10, 10, 21)));
        queryList1.add(new Query(3, "Scala", LocalDateTime.of(2019, 3, 28, 15, 45, 12)));
        addUserWithQueries(user1, queryList1);

        User user2 = new User(2, "Semen");
        List<Query> queryList2 = new ArrayList<>();
        queryList2.add(new Query(1, "Java", LocalDateTime.of(2020, 3, 28, 14, 33, 48)));
        queryList2.add(new Query(2, "Python", LocalDateTime.of(2019, 3, 28, 10, 10, 21)));
        queryList2.add(new Query(3, "Scala", LocalDateTime.of(2017, 3, 28, 15, 45, 12)));
        addUserWithQueries(user2, queryList2);

        System.out.println("Print all queries");
        printAllUsersWithQueries();

        System.out.println("\nPrint all queries history");
        printAllUsersWithQueriesHistory();

        addQueryToUser(user1, new Query(4, "Python", LocalDateTime.of(2023, 3, 28, 10, 10, 21)));

        System.out.println("\nPrint all queries history");
        printAllUsersWithQueriesHistory();

        removeUserWithQueries(user1);

        System.out.println("\nPrint all queries history after remove user 1");
        printAllUsersWithQueriesHistory();
    }

    public static void addUserWithQueries(User user, List<Query> queries) {
        queryUserMap.put(user, queries);
    }

    public static void addQueryToUser(User user, Query query) {
        queryUserMap.computeIfAbsent(user, key -> new ArrayList<>()).add(query);
    }

    public static void removeUserWithQueries(User user) {
        queryUserMap.remove(user);
    }

    public static void printAllUsersWithQueries() {
        for (Map.Entry<User, List<Query>> entry : queryUserMap.entrySet()) {
            System.out.println(entry.getKey().getName() + ":");
            entry.getValue().forEach(System.out::println);
        }
    }

    public static void printAllUsersWithQueriesHistory() {
        for (Map.Entry<User, List<Query>> entry : queryUserMap.entrySet()) {
            System.out.println(entry.getKey().getName() + ":");
            entry.getValue().stream()
                    .sorted(Comparator.comparing(Query::getTimestamp))
                    .forEach(System.out::println);
        }
    }
}
