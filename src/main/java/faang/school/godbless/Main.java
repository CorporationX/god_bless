package faang.school.godbless;

import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<User, List<Query>> userQueries = new HashMap<>();

    public static void main(String[] args) {
        User anton = new User(1, "Anton");
        User john = new User(2, "John");
        User jane = new User(3, "Jane");

        userQueries.put(anton, new ArrayList<>());
        userQueries.put(john, new ArrayList<>());
        userQueries.put(jane, new ArrayList<>());

        addQueryToUser(anton, new Query(1, "content", LocalDateTime.of(
                2016, 6, 8, 2, 10)));
        addQueryToUser(anton, new Query(2, "content", LocalDateTime.of(
                2022, 6, 7, 2, 10)));
        addQueryToUser(anton, new Query(3, "content", LocalDateTime.of(
                2022, 6, 8, 2, 10)));

        addQueryToUser(john, new Query(1, "content", LocalDateTime.of(
                2024, 6, 8, 2, 10)));
        addQueryToUser(john, new Query(2, "content", LocalDateTime.of(
                2020, 6, 8, 2, 10)));
        addQueryToUser(john, new Query(3, "content", LocalDateTime.of(
                2022, 6, 8, 2, 10)));

        addQueryToUser(jane, new Query(1, "content", LocalDateTime.of(
                2022, 6, 8, 2, 10)));
        addQueryToUser(jane, new Query(2, "content", LocalDateTime.of(
                2023, 6, 8, 2, 10)));
        addQueryToUser(jane, new Query(3, "content", LocalDateTime.of(
                2020, 8, 8, 2, 10)));


        printAllUserWithQueries();
        System.out.println("----------------------");
        printHistoryUser(anton);
        System.out.println("----------------------");
        printHistoryUser(john);
        System.out.println("-----------------------");
        printHistoryUser(jane);
    }

    public static void addUserWithQueries(User user, List<Query> queries) {
        userQueries.put(user, queries);
    }

    public static void addQueryToUser(User user, Query query) {
        userQueries.get(user).add(query);
    }

    public static void removeUser(User user) {
        userQueries.remove(user);
    }

    public static void printAllUserWithQueries() {
        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void printHistoryUser(@NonNull User user) {
        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            if (user.getId() == entry.getKey().getId()) {
                System.out.println(entry.getKey());
                entry.getValue()
                        .stream()
                        .sorted(Comparator.comparing(query -> query.getTimestamp(), Comparator.reverseOrder()))
                        .forEach(System.out::println);
                return;
            }
        }
    }
}