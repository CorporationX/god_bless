package dima.evseenko.query;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        User dima = new User(1L, "Dima");
        User vasya = new User(2L, "Vasya");

        QueryService queryService = new QueryService();
        queryService.addQueries(dima, getQueries1());
        queryService.addQueries(vasya, getQueries2());

        queryService.printQueries();

        queryService.deleteQuery(dima, new Query(3L, "query3..."));
        queryService.deleteQuery(vasya, new Query(5L, "query5..."));
        queryService.printQueries();

        for (long i = 0; i < 10; i++) {
            TimeUnit.MILLISECONDS.sleep(1);
            queryService.addQuery(vasya, new Query(i, "query%s...".formatted(i)));
        }

        queryService.printQueries();
        queryService.printUserQueriesHistory(vasya);

        queryService.deleteUser(vasya);
        queryService.printQueries();
    }

    private static List<Query> getQueries1() {
        return List.of(
                new Query(1L, "query1..."),
                new Query(2L, "query2..."),
                new Query(3L, "query3...")
        );
    }

    private static List<Query> getQueries2() {
        return List.of(
                new Query(4L, "query4..."),
                new Query(5L, "query5..."),
                new Query(6L, "query6...")
        );
    }
}
