package faang.school.godbless.r_edzie.elk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Main {
    private static Map<User, List<Query>> usersQueries = new HashMap<>();

    public static void main(String[] args) {
        User vova = new User(1, "Vova");
        User nastya = new User(3, "Nastya");
        User dima = new User(2, "Dima");

        List<Query> queriesOfVova = List.of(
                new Query(1, "a"),
                new Query(2, "b"),
                new Query(3, "c")
        );

        List<Query> queriesOfDima = List.of(
                new Query(5, "aa")
        );

        Query query = new Query(4, "d");

        add(vova, queriesOfVova);
        addQuery(vova, query);
        add(nastya, new ArrayList<>());
        add(dima, queriesOfDima);

        printUserSearches(vova);

        remove(nastya);

        printAll();
    }


    public static void add(User user, List<Query> queries) {
        queries.forEach(query -> {
            usersQueries.computeIfAbsent(user, k -> new ArrayList<>()).add(query);
        });
    }

    public static void addQuery(User user, Query query) {
        usersQueries.computeIfAbsent(user, k -> new ArrayList<>()).add(query);
    }

    public static void remove(User user) {
        usersQueries.remove(user);
    }

    public static void printAll() {
        usersQueries.forEach((user, queries) -> System.out.println(user.getName() + " " + queries));
    }

    public static void printUserSearches(User user) {
        TreeSet<Query> queries = new TreeSet<>(usersQueries.get(user));

        System.out.println(user.getName() + "\n" + queries);
    }

}
