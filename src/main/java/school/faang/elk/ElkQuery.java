package school.faang.elk;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ElkQuery {
    private Map<User, List<Query>> usersQueries;

    public ElkQuery() {
        this.usersQueries = new HashMap<>();
    }

    public void addUser(User user, List<Query> queries) {
        usersQueries.put(user, queries);
    }

    public void addQueryForUser(User user, Query query) {
        usersQueries.putIfAbsent(user, new ArrayList<>());
        usersQueries.get(user).add(query);
    }

    public void deleteUser(User user) {
        usersQueries.remove(user);
    }

    public void printAllUsersWithQueries() {
        usersQueries.forEach(
                (user, queries) -> {
                    System.out.println("User: " + user);
                    queries.forEach(query -> System.out.println(" - " + query));
                }
        );
    }

    public void printAllUsersWithQueriesSortedByTimestamp() {
        usersQueries.forEach(
                (user, queries) -> {
                    System.out.println("User: " + user);
                    queries.stream()
                            .sorted(Comparator.comparing(Query::getTimestamp))
                            .forEach(query -> System.out.println(" - " + query));
                }
        );
    }
}
