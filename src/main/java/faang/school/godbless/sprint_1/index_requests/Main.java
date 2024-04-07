package faang.school.godbless.sprint_1.index_requests;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<User, List<Query>> USER_QUERIES_MAP = new HashMap<>();

    public static void main(String[] args) {

        addNewUserWithQueries(new User("test1"), new ArrayList<>(List.of(
                new Query("something", LocalDateTime.now()),
                new Query("new", LocalDateTime.now().minusWeeks(1)),
                new Query("another query", LocalDateTime.now().minusDays(2))
        )));

        addNewUserWithQueries(new User("test2"), new ArrayList<>(List.of(
                new Query("test1", LocalDateTime.now()),
                new Query("test2", LocalDateTime.now().minusMonths(1)),
                new Query("test3", LocalDateTime.now().minusYears(2))
        )));

        printAllUsersWithQueries();
        printStoryOfQueries(new User(0, "test1"));

        deleteUserWithQueries(new User(0, "test1"));
        printAllUsersWithQueries();

        addQuery(new User(1, "test2"), List.of(
                new Query("newest", LocalDateTime.now())
        ));
        printAllUsersWithQueries();

    }

    // с проверками метод addNewUserWithQueries и addQuery выглядят одинаково
    public static void addNewUserWithQueries(User user, List<Query> queries) {
        USER_QUERIES_MAP.computeIfAbsent(user, k -> new ArrayList<>())
                .addAll(queries);
    }

    public static void addQuery(User user, List<Query> queries) {
        USER_QUERIES_MAP.computeIfAbsent(user, k -> new ArrayList<>())
                .addAll(queries);
    }

    public static void deleteUserWithQueries(User user) {
        USER_QUERIES_MAP.remove(user);
    }

    public static void printAllUsersWithQueries() {
        USER_QUERIES_MAP.forEach((k, v) -> System.out.printf("%s -> %s%n", k, v));
    }

    public static void printStoryOfQueries(User user) {
        USER_QUERIES_MAP.get(user).stream()
                .sorted(Comparator.comparing(Query::getTimestamp).reversed())
                .forEach(System.out::println);
    }
}