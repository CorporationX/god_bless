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
        queryUserMap.computeIfAbsent(user, queries -> new ArrayList<>()).add(query);
    }

    public void removeUser(Map<User, List<Query>> queryUserMap, User user) {
        if (queryUserMap.containsKey(user)) {
            queryUserMap.remove(user);
        } else {
            throw new IllegalArgumentException("User don't exist");
        }
    }

    public void showUsersQueriesInfo(Map<User, List<Query>> queryUserMap) {
        queryUserMap.forEach((user, queries) -> {
            System.out.println("Name: " + user.getName());
            queries.forEach(this::printQuery);
        });
    }

    public void showUserQueriesHistory(Map<User, List<Query>> queryUserMap, User user) {
        List<Query> queries = queryUserMap.get(user);
        if (queries != null) {
            System.out.println("Name: " + user.getName());
            queries.stream()
                    .sorted(comparing(Query::getTimestamp))
                    .forEach(this::printQuery);
        } else {
            throw new IllegalArgumentException("No queries found for user: " + user.getName());
        }
    }

    private void printQuery(Query query) {
        System.out.println("Query id: " + query.getId() +
                ", Content: " + query.getContent() +
                ", Timestamp: " + query.getTimestamp());
    }
}
