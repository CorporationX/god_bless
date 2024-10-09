package dima.evseenko.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class QueryService {
    private final Map<User, List<Query>> userQueries = new HashMap<>();

    public void addQuery(User user, Query query) {
        if (Objects.nonNull(user) && Objects.nonNull(query)) {
            userQueries.computeIfAbsent(user, k -> new ArrayList<>()).add(query);
        }
    }

    public void addQueries(User user, List<Query> queries) {
        if (Objects.nonNull(queries)) {
            queries.forEach(q -> addQuery(user, q));
        }
    }

    public void deleteQuery(User user, Query query) {
        if (userQueries.containsKey(user)) {
            userQueries.get(user).remove(query);
        }
    }

    public void deleteQueries(User user, List<Query> queries) {
        if (Objects.nonNull(queries)) {
            queries.forEach(q -> deleteQuery(user, q));
        }
    }

    public void deleteUser(User user) {
        userQueries.remove(user);
    }

    public List<Query> getQueries(User user) {
        return userQueries.get(user);
    }

    public void printUserQueriesHistory(User user) {
        List<Query> queries = new ArrayList<>(userQueries.get(user));
        Collections.sort(queries);
        System.out.println(user + " queries history:");
        queries.forEach(q -> System.out.println(q.toString()));
    }

    public void printQueries() {
        userQueries.forEach((user, queries) -> System.out.println(user + ": " + queries));
        System.out.println();
    }
}
