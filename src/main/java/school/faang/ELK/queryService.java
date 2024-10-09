package school.faang.ELK;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class queryService {

    public static void addUser(User user, List<Query> queries, Map<User, List<Query>> users) {
        users.put(user, queries);
    }

    public static void addQueryToUser(User user, Query query, Map<User, List<Query>> users) {
        users.get(user).add(query);
    }

    public static void removeUser(User user, Map<User, List<Query>> users) {
        users.remove(user);
    }

    public static void printUsers(Map<User, List<Query>> users) {
        users.forEach((user, queries) -> {
            System.out.println(user + ": ");
            queries.stream().sorted(Comparator.comparing(Query::getTimestamp)).
                    forEach(System.out::println);
        });
    }
}
