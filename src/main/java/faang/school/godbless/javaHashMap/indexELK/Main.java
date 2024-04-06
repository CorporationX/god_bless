package faang.school.godbless.javaHashMap.indexELK;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        QueryService queryService = new QueryService();

        System.out.println("Users and their queries at start point:");
        queryService.printUsersWithQueries();


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
        queryService.printUsersWithQueries();


        Thread.sleep(3000);
        System.out.println("\n\nRemoving Oleg from index.");
        queryService.removeUser(oleg);

        System.out.println("Users and their queries at this point:");
        queryService.printUsersWithQueries();


        Thread.sleep(3000);
        System.out.println("\n\nAdding new Vasya query.");

        Query newQuery = new Query(5, "Go coditi!");
        newQuery.setTimestamp(newQuery.getTimestamp().minus(2, ChronoUnit.DAYS));
        queryService.addNewQuery(vasya, newQuery);

        System.out.println("Users and their queries at this point:");
        queryService.printUsersWithQueries();


        Thread.sleep(3000);
        System.out.println("\n\nPrinting Vasya query history.");
        queryService.printUserQueryHistory(vasya);
    }
}
