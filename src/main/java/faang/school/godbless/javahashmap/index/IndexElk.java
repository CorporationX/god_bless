package faang.school.godbless.javahashmap.index;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexElk {

    private final Map<User, List<Query>> index = new HashMap<>();

    public void addUser(User user, List<Query> queries) {
        index.put(user, queries);
    }

    public void addQuery(User user, Query query) {
        List<Query> queries = index.computeIfAbsent(
                user,
                k -> new ArrayList<>());

        queries.add(query);
    }

    public void removeUser(User user) {
        index.remove(user);
    }

    public void printAllUsersAndQueries() {
        index.forEach((user, queries) -> {
            System.out.println("User: " + user);
            queries.forEach(query -> System.out.println("   Query: " + query));
        });
    }

    public void printUserQueriesHistory(User user) {
        if (index.containsKey(user)) {
            List<Query> queries = index.get(user);
            queries.sort(Comparator.comparing(Query::getTimestamp));
            System.out.println("User: " + user);
            queries.forEach(query -> System.out.println("   Query: " + query));
        } else {
            System.out.println("User not found.");
        }
    }

    public Map<User, List<Query>> getIndex() {
        return index;
    }
}
