package faang.school.godbless.task15;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<User, List<Query>> history = new HashMap<>();

    public static void addUserWithQueries(User user, List<Query> queries) {
        history.put(user, queries);
    }

    public static void addQuery(User user, Query query) {
        List<Query> queries = history.get(user);
        if (queries == null) {
            queries = new ArrayList<>();
            history.put(user, queries);
        }
        queries.add(query);
    }

    public static void removeUserQueries(User user) {
        history.remove(user);
    }

    public static void showAllQueries() {
        for (Map.Entry<User, List<Query>> userQueriesEntry : history.entrySet()) {
            System.out.println("\t" + "Пользователь: " + userQueriesEntry.getKey());
            showHistoryUserQueries(userQueriesEntry.getKey());
            System.out.println();
        }
    }

    public static void showHistoryUserQueries(User user) {
        List<Query> queries = history.get(user);
        queries.sort((o1, o2) -> Long.compare(o1.getTimestamp().getTime(), o2.getTimestamp().getTime()));
        System.out.println("Queries:");
        for (Query query : queries) {
            System.out.println(query);
        }
    }


    public static void main(String[] args) {
        addUserWithQueries(new User("129487192784", "Vova"), new ArrayList<>(List.of(
                new Query("0", "create table users(id int)", new Timestamp(System.currentTimeMillis())),
                new Query("1", "alter table users add nickname varchar(255)",
                        new Timestamp(System.currentTimeMillis()))
                ))
        );
        addUserWithQueries(new User("104807398489", "Boba"), new ArrayList<>(List.of(
                new Query("3", "select * from users", new Timestamp(System.currentTimeMillis())),
                new Query("4", "alter table users add mobilePhone varchar(25)",
                        new Timestamp(System.currentTimeMillis()))
                ))
        );
        addQuery(new User("129487192784", "Vova"),
                 new Query("3", "select * from users", new Timestamp(System.currentTimeMillis())));
        removeUserQueries(new User("104807398489", "Boba"));
        showAllQueries();
    }
}
