package faang.school.godbless.queryIndex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<User, List<Query>> listOfUserQueries = new HashMap<>();

    public static void addNewUserWithQueries(User user, List<Query> queries) {
        queries.sort(Comparator.comparing(Query::getTimestamp));
        listOfUserQueries.put(user, queries);
    }

    public static void addNewQuery(User user, Query query) {
        listOfUserQueries.get(user).add(query);
    }

    public static void removeUser(User user) {
        listOfUserQueries.remove(user);
    }

    public static StringBuilder addToOutput(User user, List<Query> queries) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(user).append(":").append(System.lineSeparator());
        queries.forEach(query -> stringBuilder.append("    -").append(query).append(System.lineSeparator()));
        return stringBuilder;
    }

    public static void printAllUsersWithQueries() {
        StringBuilder stringBuilder = new StringBuilder();
        listOfUserQueries.forEach((user, queries) -> stringBuilder.append(addToOutput(user, queries)));
        System.out.println(stringBuilder);
    }

    public static void printUserQueries(User user) {
        List<Query> queries = listOfUserQueries.get(user);
        System.out.println(addToOutput(user, queries));
    }

    public static void main(String[] args) {
        User alexey = new User(1, "Алексей");
        User victor = new User(2, "Виктор");

        Query alexeyQuery1 = new Query(1, "Запрос 1", LocalDateTime.now());
        Query alexeyQuery2 = new Query(2, "Запрос 2", LocalDateTime.of(2024, 7, 17, 23, 54));
        Query alexeyQuery3 = new Query(3, "Запрос 3", LocalDateTime.of(2024, 7, 16, 22, 54));
        Query alexeyQuery4 = new Query(4, "Запрос 4", LocalDateTime.of(2024, 7, 16, 23, 54));

        List<Query> alexeyQueries = new ArrayList<>();
        alexeyQueries.add(alexeyQuery1);
        alexeyQueries.add(alexeyQuery2);
        alexeyQueries.add(alexeyQuery3);
        alexeyQueries.add(alexeyQuery4);

        addNewUserWithQueries(alexey, alexeyQueries);
        printUserQueries(alexey);
        System.out.println("----------------------");
        Query victorQuery1 = new Query(1, "Запрос 1", LocalDateTime.of(2024, 8, 7, 23, 54));
        Query victorQuery2 = new Query(2, "Запрос 2", LocalDateTime.of(2024, 7, 31, 23, 44));
        Query victorQuery3 = new Query(2, "Запрос 3", LocalDateTime.now());

        List<Query> victorQueries = new ArrayList<>();
        victorQueries.add(victorQuery1);
        victorQueries.add(victorQuery2);
        addNewUserWithQueries(victor, victorQueries);
        printAllUsersWithQueries();
        System.out.println("----------------------");
        addNewQuery(victor, victorQuery3);
        printUserQueries(victor);
        System.out.println("----------------------");
        removeUser(victor);
        printAllUsersWithQueries();
    }
}
