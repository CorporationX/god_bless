package faang.school.godbless.java.sql.elk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<User, List<Query>> userQueriesMap = new HashMap<>();

        List<Query> vasiaQueries = new ArrayList<>();
        User userVasia = new User(1, "Vasia");
        vasiaQueries.add(new Query(1, "Dog"));
        vasiaQueries.add(new Query(2, "Cat"));

        addNewUserWithQueries(userQueriesMap, userVasia, vasiaQueries);

        List<Query> koliaQueries = new ArrayList<>();
        User userKolia = new User(2, "Kolia");
        koliaQueries.add(new Query(1, "Monkey"));
        koliaQueries.add(new Query(2, "Taxi"));

        addNewUserWithQueries(userQueriesMap, userKolia, koliaQueries);

        addNewQueryToExistingUser(userQueriesMap, userVasia, new Query(3, "Train"));


        List<Query> johnQueries = new ArrayList<>();
        User userJohn = new User(3, "John");
        johnQueries.add(new Query(1, "Chocolate"));
        johnQueries.add(new Query(2, "Ice cream"));

        addNewUserWithQueries(userQueriesMap, userJohn, johnQueries);
        deleteUser(userQueriesMap, userJohn);

        List<Query> maxQueries = new ArrayList<>();
        User userMax = new User(4, "Max");
        maxQueries.add(new Query(1, "Tennis", "2024-06-05T11:50:55"));
        maxQueries.add(new Query(2, "Football", "2024-05-05T22:50:55"));
        maxQueries.add(new Query(3, "Table tennis", "2024-05-05T20:50:55"));

        addNewUserWithQueries(userQueriesMap, userMax, maxQueries);

        showUsersQueries(userQueriesMap);

        showUserQueryHistory(userQueriesMap, userMax);

    }

    public static void addNewUserWithQueries(Map<User, List<Query>> userQueriesMap, User user, List<Query> queries) {
        userQueriesMap.put(user, queries);
    }

    public static void addNewQueryToExistingUser(Map<User, List<Query>> userQueriesMap, User user, Query query) {
        userQueriesMap.computeIfAbsent(user, k -> new ArrayList<>()).add(query);
    }

    public static void deleteUser(Map<User, List<Query>> userQueriesMap, User user) {
        userQueriesMap.remove(user);
    }

    public static void showUsersQueries(Map<User, List<Query>> userQueriesMap) {
        for (Map.Entry<User, List<Query>> entry: userQueriesMap.entrySet()) {
            System.out.printf("%nUser %s made the following queries:%n", entry.getKey().getName());
            for (Query query: entry.getValue()) {
                System.out.printf("%s, ", query.getContent());
            }
            System.out.println();
        }
    }

    public static void showUserQueryHistory(Map<User, List<Query>> userQueriesMap, User user) {
        userQueriesMap.get(user).sort(Comparator.comparing(Query::getTimestamp));
        System.out.printf("%nUser %s made the following queries:%n", user.getName());
        for (Query query: userQueriesMap.get(user)) {
            System.out.printf("%s, %s %n", query.getContent(), query.getTimestamp());
        }
    }
}
