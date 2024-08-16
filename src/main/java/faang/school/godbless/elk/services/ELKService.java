package faang.school.godbless.elk.services;

import faang.school.godbless.elk.models.Query;
import faang.school.godbless.elk.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ELKService {

    public static void addUserQueries(User user, List<Query> queries, Map<User, List<Query>> userQueriesELK) {
        if (userQueriesELK.containsKey(user)) {
            userQueriesELK.get(user).addAll(queries);
        } else {
            userQueriesELK.put(user, queries);
        }
    }

    public static void addQueryForUser(User user, Query query, Map<User, List<Query>> userQueriesELK) {
        List<Query> queries = new ArrayList<>();

        if (userQueriesELK.containsKey(user)) {
            queries = userQueriesELK.get(user);
        }

        queries.add(query);

        if (!userQueriesELK.containsKey(user)) {
            userQueriesELK.put(user, queries);
        }
    }

    public static void deleteUserFromELK(User user, Map<User, List<Query>> userQueriesELK) {
        userQueriesELK.remove(user);
    }

    public static void printAllInfoFromELK(Map<User, List<Query>> userQueriesELK) {
        userQueriesELK.forEach((key, value) -> {
            System.out.println(key + " has next queries: ");
            value.forEach(System.out::println);
        });
    }

    public static void printAllInfoFromELKOrderedByDateCreated(Map<User, List<Query>> userQueriesELK) {
        for (Map.Entry<User, List<Query>> user : userQueriesELK.entrySet()) {
            System.out.println("User " + user.getKey().getId() + " - " + user.getKey().getName() + " has next queries");
            user.getValue().stream().sorted(Query::compareTo).forEach(System.out::println);
        }
    }
}