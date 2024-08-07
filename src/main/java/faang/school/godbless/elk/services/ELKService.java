package faang.school.godbless.elk.services;

import faang.school.godbless.elk.models.Query;
import faang.school.godbless.elk.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.elk.Main.userQueriesELK;

public class ELKService {

    public static void addUserQueries(User user, List<Query> queries) {
        if (userQueriesELK.containsKey(user)) {
            userQueriesELK.get(user).addAll(queries);
        } else {
            userQueriesELK.put(user, queries);
        }
    }

    public static void addQueryForUser(User user, Query query) {
        List<Query> queries = new ArrayList<>();

        if (userQueriesELK.containsKey(user)) {
            queries = userQueriesELK.get(user);
        }

        queries.add(query);

        if (!userQueriesELK.containsKey(user)) {
            userQueriesELK.put(user, queries);
        }
    }

    public static void deleteUserFromELK(User user) {
        userQueriesELK.remove(user);
    }

    public static void printAllInfoFromELK() {
        userQueriesELK.entrySet().forEach(userListEntry -> {
            System.out.println(userListEntry.getKey() + " has next queries: ");
            userListEntry.getValue().forEach(System.out::println);
        });
    }

    public static void printAllInfoFromELKOrderedByDateCreated() {
        for (Map.Entry<User, List<Query>> user : userQueriesELK.entrySet()) {
            System.out.println("User " + user.getKey().getId() + " - " + user.getKey().getName() + " has next queries");
            user.getValue().stream().sorted(Query::compareTo).forEach(System.out::println);

        }
    }

}
