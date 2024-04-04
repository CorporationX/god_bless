package faang.school.godbless.javaHashMap.indexELK;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final Map<User, List<Query>> index;

    public Main() {
        index = new HashMap<>();
    }

    public static void main(String[] args) throws InterruptedException {
        Main queryService = new Main();

        System.out.println("Users and their queries at start point:");
        queryService.printUsersWithRequests();


        User oleg = new User(1, "Oleg");
        User vasya = new User(2, "Vasya");

        List<Query> olegQueries = new ArrayList<>();
        olegQueries.add(new Query(1, "Go futbik!"));
        olegQueries.add(new Query(2, "Go futbik!"));
        olegQueries.add(new Query(3, "Go futbik!"));

        List<Query> vasyaQueries = new ArrayList<>();
        vasyaQueries.add(new Query(1, "Otstani!"));
        vasyaQueries.add(new Query(2, "Otstani!"));
        vasyaQueries.add(new Query(3, "Otstani!"));
        vasyaQueries.add(new Query(4, "Otstani!"));

        System.out.println("\n\nAdding two new users with their queries.");

        queryService.addNewUser(oleg, olegQueries);
        queryService.addNewUser(vasya, vasyaQueries);
        queryService.addNewUser(oleg, olegQueries);

        System.out.println("Users and their queries at this point:");
        queryService.printUsersWithRequests();


        Thread.sleep(3000);
        System.out.println("\n\nRemoving Oleg from index.");
        queryService.removeUser(oleg);

        System.out.println("Users and their queries at this point:");
        queryService.printUsersWithRequests();


        Thread.sleep(3000);
        System.out.println("\n\nAdding new Vasya query.");

        Query newQuery = new Query(5, "Go coditi!");
        newQuery.setTimestamp(newQuery.getTimestamp().minus(2, ChronoUnit.DAYS));
        queryService.addNewRequest(vasya, newQuery);

        System.out.println("Users and their queries at this point:");
        queryService.printUsersWithRequests();


        Thread.sleep(3000);
        System.out.println("\n\nPrinting Vasya query history.");
        queryService.printUserQueryHistory(vasya);
    }

    public void addNewUser(User newUser, List<Query> queries) {
        List<Query> userQueriesInIndex = index.computeIfAbsent(newUser, key -> new ArrayList<>());

        queries.forEach(query -> {
            if (!userQueriesInIndex.contains(query)) {
                userQueriesInIndex.add(query);
            }
        });
    }

    public boolean addNewRequest(User user, Query query) {
        if (!index.containsKey(user)) {
            return false;
        }

        index.get(user).add(query);
        return true;
    }

    public void removeUser(User user) {
        index.remove(user);
    }

    public void printUserQueryHistory(User user) {
        for (Map.Entry<User, List<Query>> entry : index.entrySet()) {
            System.out.println("History of queries of user " + entry.getKey().getName() + " :");

            entry.getValue().stream()
                    .sorted(Comparator.comparing(Query::getTimestamp))
                    .forEach(System.out::println);
        }
    }

    public void printUsersWithRequests() {
        if (index.isEmpty()) {
            System.out.println("Index is empty");
            return;
        }

        for (Map.Entry<User, List<Query>> entry : index.entrySet()) {
            System.out.println("User " + entry.getKey().getName() + " and his(her) queries:");
            entry.getValue().forEach(System.out::println);
            System.out.println();
        }
    }
}
