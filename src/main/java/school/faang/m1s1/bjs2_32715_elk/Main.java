package school.faang.m1s1.bjs2_32715_elk;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<User, List<Query>> USER_QUERY_MAP = new HashMap<>();
    private static final Map<Integer, User> ID_TO_USER_MAP = new HashMap<>();
    private static final Map<String, User> NAME_TO_USER_MAP = new HashMap<>();

    public static void main(String[] args) {
        addUserAndQueries(new User("Alice"), new ArrayList<>(List.of(
                new Query("Get"),
                new Query("Post")
        )));
        addUserAndQueries(new User("Bob"), new ArrayList<>(List.of(
                new Query("Post"),
                new Query("Get")
        )));
        addUserAndQueries(new User("Charlie"), new ArrayList<>(List.of(
                new Query("Post"),
                new Query("Get")
        )));

        addQueryToUser("Alice", "Delete");
        addQueryToUser(1, "RESET");
        addQueryToUser("Bob", "RESET");

        displayAllQueries();
        System.out.println();

        deleteUser(2);
        deleteUser("Charlie");

        displayAllQueries();
        System.out.println();

        displayUserQueriesById(1);

    }

    private static void addUserAndQueries(User user, List<Query> queryList) {
        USER_QUERY_MAP.computeIfAbsent(user, k -> new ArrayList<>()).addAll(queryList);
        ID_TO_USER_MAP.put(user.getId(), user);
        NAME_TO_USER_MAP.put(user.getName(), user);
    }

    private static void addQueryToUser(int id, String newQuery) {
        validateId(id);
        Query query = new Query(newQuery);
        User user = ID_TO_USER_MAP.get(id);
        USER_QUERY_MAP.get(user).add(query);
    }

    private static void addQueryToUser(String name, String newQuery) {
        validateName(name);
        Query query = new Query(newQuery);
        User user = NAME_TO_USER_MAP.get(name);
        USER_QUERY_MAP.get(user).add(query);
    }

    private static void deleteUser(int id) {
        validateId(id);
        User user = ID_TO_USER_MAP.remove(id);
        NAME_TO_USER_MAP.remove(user.getName());
        USER_QUERY_MAP.remove(user);
    }

    private static void deleteUser(String name) {
        validateName(name);
        User user = NAME_TO_USER_MAP.remove(name);
        ID_TO_USER_MAP.remove(user.getId());
        USER_QUERY_MAP.remove(user);
    }

    private static void validateId(int id) {
        if (!ID_TO_USER_MAP.containsKey(id)) {
            throw new IllegalArgumentException("User with id " + id + " doesn't exist");
        }
    }

    private static void validateName(String name) {
        if (!NAME_TO_USER_MAP.containsKey(name)) {
            throw new IllegalArgumentException("User with name " + name + " doesn't exist");
        }
    }

    private static void displayAllQueries() {
        for (var entry : USER_QUERY_MAP.entrySet()) {
            System.out.printf("User %s (id #%d)\nQueries:\n", entry.getKey().getName(), entry.getKey().getId());
            for (Query query : entry.getValue()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSS");
                System.out.printf("id: %d,\t time: %s, \tquery: %s\n",
                        query.getId(), query.getTimestamp().format(formatter), query.getContent());
            }
            System.out.println();
        }
    }

    private static void displayUserQueriesById(int id) {
        User user = ID_TO_USER_MAP.getOrDefault(id, null);

        if (user == null) {
            throw new IllegalArgumentException("User with id " + id + " doesn't exist");
        } else {
            System.out.printf("User %s (id #%d)\nQueries:\n", user.getName(), user.getId());
            for (Query query : USER_QUERY_MAP.get(user)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSS");
                System.out.printf("time: %s,\t id: %d, \tquery: %s\n",
                        query.getTimestamp().format(formatter), query.getId(), query.getContent());
            }
        }
    }

}
