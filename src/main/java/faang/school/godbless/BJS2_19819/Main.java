package faang.school.godbless.BJS2_19819;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    private static final Map<User, List<Query>> userQueries = new HashMap<>();

    public static void main(String[] args) {
        addUserQueries(new User(0, "Viktor"), new ArrayList<>() {{
            add(new Query(0, "ViktorQuery1", LocalDateTime.now()));
            add(new Query(1, "ViktorQuery2", LocalDateTime.now()));
            add(new Query(2, "ViktorQuery3", LocalDateTime.now()));
        }});
        addUserQueries(new User(1, "Petr"), new ArrayList<>() {{
            add(new Query(0, "PetrQuery1", LocalDateTime.now()));
            add(new Query(1, "PetrQuery2", LocalDateTime.now()));
            add(new Query(2, "PetrQuery3", LocalDateTime.now()));
        }});
        addUserQueries(new User(2, "Ivan"), new ArrayList<>() {{
            add(new Query(0, "IvanQuery1", LocalDateTime.now()));
            add(new Query(1, "IvanQuery2", LocalDateTime.now()));
            add(new Query(2, "IvanQuery3", LocalDateTime.now()));
        }});

        printAllUsers();
        System.out.println("Add query to existing user");
        addQueryCurrUser(new User(1, "Petr"), new Query(3, "PetrQuery4", LocalDateTime.now()));
        printAllUsers();
        System.out.println("Remove user");
        removeUser(new User(0, "Viktor"));
        printAllUsers();
        System.out.println("Print user's query");
        System.out.println("------------");
        printUserQuery(new User(1, "Petr"));
    }

    public static void addUserQueries(User user, List<Query> queries) {
        userQueries.put(user, queries);
    }

    public static void addQueryCurrUser(User user, Query query) {
        userQueries.computeIfPresent(user, (key, listQueries) -> {
            listQueries.add(query);
            return listQueries;
        });
    }

    public static void removeUser(User user) {
        userQueries.remove(user);
    }

    public static void printAllUsers() {
        for (var entry : userQueries.entrySet()) {
            System.out.println(entry.getKey().getName() + ": ");
            entry.getValue().forEach(query -> System.out.println(query.getContent()));
        }
    }

    public static void printUserQuery(User user) {
        if (userQueries.containsKey(user)) {
            System.out.println(user.getName() + ": ");
            userQueries.get(user).stream()
                    .sorted(Comparator.comparing(Query::getTimestamp))
                    .forEach(t -> System.out.println(t.getContent() + " - " + t.getTimestamp()));
        }
    }
}
