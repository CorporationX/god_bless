package faang.school.godbless.bjs2_4481;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {

    private static final Map<User, List<Query>> queryUserMap = new HashMap<>();

    public static void main(String[] args) {
        User userIvan = new User(1, "Ivan");
        List<Query> queriesIvan = new ArrayList<>();
        queriesIvan.add(new Query(1, "Java", LocalDateTime.of(2019, 3, 28, 14, 33, 48)));
        queriesIvan.add(new Query(2, "Python", LocalDateTime.of(2019, 3, 28, 10, 10, 21)));
        queriesIvan.add(new Query(3, "Scala", LocalDateTime.of(2019, 3, 28, 15, 45, 12)));
        addUserWithQueries(userIvan, queriesIvan);

        User userSemen = new User(2, "Semen");
        List<Query> queriesSemen = new ArrayList<>();
        queriesSemen.add(new Query(1, "Java", LocalDateTime.of(2020, 3, 28, 14, 33, 48)));
        queriesSemen.add(new Query(2, "Python", LocalDateTime.of(2019, 3, 28, 10, 10, 21)));
        queriesSemen.add(new Query(3, "Scala", LocalDateTime.of(2017, 3, 28, 15, 45, 12)));
        addUserWithQueries(userSemen, queriesSemen);

        printAllUsersWithQueries();

        printAllUsersWithQueriesHistory();

        addQueryToUser(userIvan, new Query(4, "Python", LocalDateTime.of(2023, 3, 28, 10, 10, 21)));

        printAllUsersWithQueriesHistory();

        removeUserWithQueries(userIvan);

        printAllUsersWithQueriesHistory();
    }

    public static void addUserWithQueries(User user, List<Query> queries) {
        log.info("Add user {} with queries", user.getName());
        queryUserMap.put(user, queries);
    }

    public static void addQueryToUser(User user, Query query) {
        log.info("Add query to user {}", user.getName());
        queryUserMap.computeIfAbsent(user, key -> new ArrayList<>()).add(query);
    }

    public static void removeUserWithQueries(User user) {
        if (queryUserMap.remove(user) != null) {
            log.info("User {} was removed", user.getName());
        }
    }

    public static void printAllUsersWithQueries() {
        log.info("Print all users with queries");
        for (Map.Entry<User, List<Query>> entry : queryUserMap.entrySet()) {
            System.out.println(entry.getKey().getName() + ":");
            entry.getValue().forEach(System.out::println);
        }
    }

    public static void printAllUsersWithQueriesHistory() {
        log.info("Print all users with queries history");
        for (Map.Entry<User, List<Query>> entry : queryUserMap.entrySet()) {
            System.out.println(entry.getKey().getName() + ":");
            entry.getValue().stream()
                    .sorted(Comparator.comparing(Query::getTimestamp))
                    .forEach(System.out::println);
        }
    }
}
