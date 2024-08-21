package faang.school.godbless;


public class Main {
    public static void main(String[] args) {

        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}

import java.time.LocalTime;
import java.util.*;

public class Main {

    private static final Map<User, List<Query>> queries = new HashMap<>();

    public static void main(String[] args) {

        User user = new User(1, "Alice");

        Query query1 = new Query(1, "Query 1", LocalTime.of(10, 15));
        Query query2 = new Query(2, "Query 2", LocalTime.of(10, 30));
        Query query3 = new Query(3, "Query 3", LocalTime.of(10, 20));

        addUser(user, List.of(query1, query2, query3));

        printUserQueryHistorySortedByTime(user);
        printUsersAndQueries();

        Query query4 = new Query(4, "Query 4", LocalTime.of(10, 20));
        addQueriesToUser(user, Collections.singletonList(query4));
        removeQueriesFromUser(user, List.of(query1, query2));
        printUsersAndQueries();
    }


    public static void addUser(User user, List<Query> userQueries) {
        queries.put(user, userQueries);
    }


    public static void addQueriesToUser(User user, List<Query> additionalQueries) {
        List<Query> existingQueries = queries.get(user);
        if (existingQueries != null) {
            existingQueries.addAll(additionalQueries);
        } else {
            System.out.println("User does not exist in the queries map.");
        }
    }


    public static void removeQueriesFromUser(User user, List<Query> queriesToRemove) {
        List<Query> existingQueries = queries.get(user);
        if (existingQueries != null) {
            existingQueries.removeAll(queriesToRemove);
            if (existingQueries.isEmpty()) {
                queries.remove(user);
            } else {
                queries.put(user, existingQueries);
            }
        } else {
            System.out.println("User does not exist in the queries map.");
        }
    }

    public static void printUsersAndQueries() {
        for (Map.Entry<User, List<Query>> entry : queries.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void printUserQueryHistorySortedByTime(User user) {
        List<Query> userQueries = queries.get(user);
        if(userQueries == null || userQueries.isEmpty()) {
            System.out.println("User has no queries.");
        }

        TreeMap<LocalTime, String> sortedQueries = new TreeMap<>();

        assert userQueries != null;
        for (Query query : userQueries) {
            sortedQueries.put(query.getTimeStamp(), query.getContent());
        }

        System.out.println("User: " + user.getName());
        for (Map.Entry<LocalTime, String> entry : sortedQueries.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

