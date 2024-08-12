package faang.school.godbless.bjs2_19737;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    private Map<User, LinkedList<Query>> userQueries = new HashMap<>();

    public void addUserWithQueries(User user, LinkedList<Query> queries) {
        userQueries.put(user, queries);
    }

    public void addQueryToUser(Query query, User user) {
        var existedQueries = userQueries.get(user);
        existedQueries.addFirst(query);
    }

    public void removeUser(User user) {
        userQueries.remove(user);
    }

    public void printAllUsersWithSortedQueries() {
        userQueries.forEach((user, queries) -> {
            System.out.println("User: " + user.getName());
            printQueries(queries);
        });
    }

    public void printQueries(List<Query> queries) {
        queries.forEach(query -> System.out.println("    " + query.toString()));
    }
}
