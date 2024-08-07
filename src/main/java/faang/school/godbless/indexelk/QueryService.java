package faang.school.godbless.indexelk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;

public class QueryService {
    public void addUser(Map<User, List<Query>> queryUserMap, User user, List<Query> queries) {
        queryUserMap.put(user, queries);
    }

    public void addQuery(Map<User, List<Query>> queryUserMap, User user, Query query) {
        queryUserMap.computeIfAbsent(user, key -> new ArrayList<>()).add(query);
    }

    public void removeUser(Map<User, List<Query>> queryUserMap, User user) {
        var queries = queryUserMap.remove(user);
        queriesNullCheck(queries);
    }

    public void showUsersQueriesInfo(Map<User, List<Query>> queryUserMap) {
        queryUserMap.forEach((user, queries) -> {
            System.out.println("Name: " + user.getName());
            queries.forEach(this::printQuery);
        });
    }

    public void showUsersQueriesHistory(Map<User, List<Query>> queryUserMap) {
        queryUserMap.forEach((user, queries) -> {
            System.out.println("Name: " + user.getName());
            queries.stream()
                    .sorted(comparing(Query::getTimestamp))
                    .forEach(this::printQuery);
        });
    }

    private void queriesNullCheck(List<Query> queries) {
        if (queries == null) {
            System.out.println("Queries don't exist");
        }
    }

    private void printQuery(Query query) {
        System.out.println("Query id: " + query.getId() +
                ", Content: " + query.getContent() +
                ", Timestamp: " + query.getTimestamp());
    }
}
