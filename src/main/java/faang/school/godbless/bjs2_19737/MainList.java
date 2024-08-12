package faang.school.godbless.bjs2_19737;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainList {
    private Map<User, List<Query>> userQueries = new HashMap<>();

    public void addUserWithQueries(User user, List<Query> queries) {
        userQueries.put(user, queries);
    }

    public void addQueryToUser(Query query, User user) {
        var existedQueries = userQueries.get(user);
        existedQueries.add(query);
    }

    public void removeUser(User user) {
        userQueries.remove(user);
    }

    public void printAllUsers() {
        userQueries.forEach((user, queries) -> {
            System.out.println("User: " + user.getName());
            printQueries(queries);
        });
    }

    public void printQueries(List<Query> queries) {
        queries.forEach(query -> System.out.println("    " + query.toString()));
    }

    public void printAllUsersWithSortedQueries() {
        userQueries.forEach((user, queries) -> {
            System.out.println("User: " + user.getName());
            queries.sort(Comparator.comparing(Query::getTimestamp));
            printQueries(queries);
        });
    }

    // for tests
    public Map<User, List<Query>> getUserQueries() {
        return userQueries;
    }
}
