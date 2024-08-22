package faang.school.godbless.index.request.elk;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static final Map<User, List<Query>> userRequestMap = new HashMap<>();

    public static void main(String[] args) {

        User bob = new User(1, "Bob");
        List<Query> bobsQueries = new ArrayList<>();
        bobsQueries.add(new Query(1, "Today plain fel",
                LocalDateTime.of(LocalDate.of(2024, 8, 9),
                        LocalTime.of(12, 15, 35))));
        bobsQueries.add(new Query(2, "How to override toString() in java",
                LocalDateTime.of(LocalDate.of(2024, 8, 2),
                        LocalTime.of(10, 15, 35))));
        bobsQueries.add(new Query(3, "Weather in New York in next week",
                LocalDateTime.of(LocalDate.of(2024, 8, 5),
                        LocalTime.of(10, 55, 35))));
        addUser(bob, bobsQueries);
        System.out.println("print Bob's search history");
        printHistory(bob);

        System.out.println();
        System.out.println("add request to Bob's data");

        addRequest(bob, new Query(4, "Where I can buy potato?",
                LocalDateTime.of(LocalDate.of(2024, 8, 7),
                        LocalTime.of(22, 15, 35))));
        System.out.println();
        System.out.println("print Bob's search history");
        printHistory(bob);

        System.out.println();

        User mary = new User(2, "Mary");
        addRequest(mary, new Query(5, "The cat has a hot nose",
                LocalDateTime.of(LocalDate.of(2024, 7, 5),
                        LocalTime.of(10, 15, 35))));
        addRequest(mary, new Query(6, "Java HashMap explanation",
                LocalDateTime.of(LocalDate.of(2024, 8, 5),
                        LocalTime.of(9, 15, 35))));
        System.out.println("print Mary's search history");
        printHistory(mary);

        System.out.println();
        System.out.println("print all");
        System.out.println();

        printAll();
        System.out.println();

        System.out.println("delete Mary");
        deleteUser(mary);

        System.out.println();
        System.out.println("printAll");
        System.out.println();
        printAll();
    }

    public static void addUser(User user, List<Query> queries) {
        userRequestMap.put(user, queries);
    }

    public static void addRequest(User user, Query query) {
        userRequestMap.computeIfAbsent(user, k -> new ArrayList<>()).add(query);
    }

    public static void deleteUser(User user) {
        userRequestMap.remove(user);
    }

    private static void printAll() {
        userRequestMap.forEach(((user, queries) -> {
            System.out.println(user);
            queries.forEach(System.out::println);
            System.out.println();
        }));
    }

    private static void printHistory(User user) {
        for (Map.Entry<User, List<Query>> userQueries : userRequestMap.entrySet()) {
            if (userQueries.getKey().equals(user)) {
                System.out.println(userQueries.getKey());
                userQueries.getValue()
                        .sort(Comparator.comparing(Query::getTimestamp).reversed());

                userQueries.getValue().forEach(System.out::println);
            }
        }
    }
}
