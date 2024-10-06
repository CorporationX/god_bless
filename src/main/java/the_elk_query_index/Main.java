package the_elk_query_index;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static final Map<User, List<Query>> USER_QUERIES = new HashMap<>();

    public static void main(String[] args) {
        User firstUser = new User(1, "John");
        User secondUser = new User(2, "Jane");

        Query firstQuery = new Query(1, "Hello World", 123456789);
        Query secondQuery = new Query(2, "How are you?", 98765321);
        Query thirdQuery = new Query(3, "What's up?", 98765321);

        addUser(firstUser, List.of(firstQuery, secondQuery));
        addUser(secondUser, List.of(firstQuery));

        addQuery(firstUser, thirdQuery);

        printUsersQueries();
        removeUser(secondUser);
        printUsersQueries();
        addUser(firstUser, List.of(firstQuery, secondQuery));
        printUsersQueries();
    }

    public static void addUser(User user, List<Query> queries) {
        USER_QUERIES.put(user, queries);
    }

    public static void addQuery(User user, Query query) {
        USER_QUERIES.compute(user, (k, v) -> {
            if (v == null) {
                v = new ArrayList<>();
            } else if (!(v instanceof ArrayList)) {
                v = new ArrayList<>(v);
            }
            v.add(query);
            return v;
        });
    }

    public static void removeUser(User user) {
        USER_QUERIES.remove(user);
    }

    public static void printUsersQueries() {
        for (Map.Entry<User, List<Query>> entry : USER_QUERIES.entrySet()) {
            User user = entry.getKey();
            List<Query> queries = entry.getValue();
            System.out.println(user.getName() + ":");
            List<Query> sortedQueries = new ArrayList<>(queries);
            sortedQueries.sort(Comparator.comparing(Query::getTimestamp));
            sortedQueries.forEach(query -> System.out.println("  " + query.getId() + " " + query.getContent() + " " + query.getTimestamp()));
        }
    }
}
