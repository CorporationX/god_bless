package faang.school.godbless.r_edzie.elk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<User, List<Query>> usersQueries = new HashMap<>();

    public static void main(String[] args) {
        User vova = new User(1, "Vova");
        User nastya = new User(3, "Nastya");
        User dima = new User(2, "Dima");

        List<Query> queriesOfVova = List.of(
                new Query(1, "a", "111"),
                new Query(2, "b", "222"),
                new Query(3, "c", "333")
        );

        List<Query> queriesOfDima = List.of(
                new Query(5, "aa", "1sa")
        );

        Query query = new Query(4, "d", "444");

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
        List<Query> userQueries = usersQueries.get(user);

        for (Query userQuery : userQueries) {
            System.out.println(userQuery);
        }
    }

}
