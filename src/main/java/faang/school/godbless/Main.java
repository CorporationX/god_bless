package faang.school.godbless;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<User, List<Query>> userQueriesMap = new HashMap<>();

        User tom = new User("Tom");
        User kate = new User("Kate");

        addQueryForUser(userQueriesMap, tom, new Query("How are you?"));
        addQueryForUser(userQueriesMap, tom, new Query("What is ELK?"));
        addQueryForUser(userQueriesMap, kate, new Query("Coffee shop near me"));

        printAllUsersAndQueries(userQueriesMap);

        printUserQueryHistory(userQueriesMap, tom);

        deleteUser(userQueriesMap, tom);

        printAllUsersAndQueries(userQueriesMap);
    }

    public static void addQueryForUser(HashMap<User, List<Query>> map, User user, Query query) {
        map.computeIfAbsent(user, k -> new ArrayList<>()).add(query);
    }

    public static void deleteUser(HashMap<User, List<Query>> map, User user) {
        map.remove(user);
    }

    public static void printAllUsersAndQueries(HashMap<User, List<Query>> map) {
        map.forEach((user, queries) -> {
            System.out.println("User: " + user.getName());
            queries.forEach(query -> System.out.println("   Query: " + query));
        });
    }

    public static void printUserQueryHistory(HashMap<User, List<Query>> map, User user) {
        List<Query> queries = map.get(user);
        if (queries != null) {
            System.out.println("Query history for " + user.getName() + ":");
            queries.stream()
                    .sorted(Comparator.comparing(Query::getTimestamp))
                    .forEach(query -> System.out.println("   Query: " + query));
        } else {
            System.out.println("No queries found for user: " + user.getName());
        }
    }
}