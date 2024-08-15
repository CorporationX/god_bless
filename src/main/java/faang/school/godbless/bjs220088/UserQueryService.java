package faang.school.godbless.bjs220088;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class UserQueryService {
    public void addUserQuery(Map<User, List<Query>> indexedQueries, User user, Query query) {
        indexedQueries.computeIfAbsent(user, u -> new ArrayList<>()).add(query);
    }

    public void deleteUser(Map<User, List<Query>> indexedQueries, User user) {
        indexedQueries.remove(user);
    }

    public void printAllUsersQueries(Map<User, List<Query>> indexedQueries) {
        for (Map.Entry<User, List<Query>> entry : indexedQueries.entrySet()) {
            System.out.println(entry
                    .getKey()
                    .getName() + ": ");
            sortByTime(entry
                    .getValue())
                    .forEach(System.out::println);
        }
    }

    public void printUserQueries(Map<User, List<Query>> indexedQueries, User user) {
        System.out.println(user.getName());
        sortByTime(indexedQueries
                .get(user))
                .forEach(System.out::println);
    }

    private List<Query> sortByTime(List<Query> queries) {
        return queries
                .stream()
                .sorted(Comparator
                        .comparing(Query::getTimestamp)
                        .reversed())
                .toList();
    }

}
