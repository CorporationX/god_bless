package faang.school.godbless.javaHashMap.indexELK;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryService {
    private final Map<User, List<Query>> index;

    public QueryService() {
        index = new HashMap<>();
    }

    public void addNewUser(User newUser, List<Query> queries) {
        List<Query> userQueriesInIndex = index.computeIfAbsent(newUser, key -> new ArrayList<>());

        queries.forEach(query -> {
            if (!userQueriesInIndex.contains(query)) {
                userQueriesInIndex.add(query);
            }
        });
    }

    public boolean addNewQuery(User user, Query query) {
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
        System.out.println("History of queries of user " + user.getName() + " :");

        index.get(user).stream()
                .sorted(Comparator.comparing(Query::getTimestamp))
                .forEach(System.out::println);
    }

    public void printUsersWithQueries() {
        if (index.isEmpty()) {
            System.out.println("Index is empty");

            return;
        }

        index.forEach(((user, queries) -> {
            System.out.println("User " + user.getName() + " and his(her) queries:");
            queries.forEach(System.out::println);
            System.out.println();
        }));
    }
}
