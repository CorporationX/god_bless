package faang.school.godbless.Hashmap.QueriesIndexing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<User, List<Query>> USER_QUERIES = new HashMap<>();

    public static void main(String[] args) {

        Main app = new Main();

        User user1 = new User(1, "Jahseh");
        User user2 = new User(2, "Ricardo");
        User user3 = new User(3, "Oleg");

        Query query1 = new Query(1, "Watch Game of Thrones 3 season", LocalDateTime.now());
        Query query2 = new Query(2, "Time in Moscow now", LocalDateTime.now());
        Query query3 = new Query(3, "Sell honda civic 2007 Istanbul", LocalDateTime.now());
        Query query4 = new Query(4, "Faang School Boot Camp", LocalDateTime.now());
        Query query5 = new Query(5, "Tantum Verde Forte", LocalDateTime.now());
        Query query6 = new Query(6, "word disingenuous on Spanish?", LocalDateTime.now());
        Query query7 = new Query(7, "Drake album 2024 listen youtube", LocalDateTime.now());
        Query query8 = new Query(8, "How long turtles live?", LocalDateTime.now());

        List<Query> queryHistory1 = new ArrayList<>();
        List<Query> queryHistory2 = new ArrayList<>();
        List<Query> queryHistory3 = new ArrayList<>();

        queryHistory1.add(query1);
        queryHistory1.add(query3);
        queryHistory1.add(query4);
        queryHistory2.add(query4);
        queryHistory2.add(query2);
        queryHistory3.add(query8);

        app.addNewUser(user1, queryHistory1);
        app.addNewUser(user2, queryHistory2);
        app.addNewUser(user3, queryHistory3);

        app.addNewQuery(user1, query7);
        app.addNewQuery(user3, query5);
        app.addNewQuery(user3, query6);

        app.deleteUser(2);

        app.printAllQueries();
    }

    public void addNewUser(User user, List<Query> query) {
        if (user == null || query == null) {
            throw new IllegalArgumentException("User or query cannot be null");
        }

        USER_QUERIES.put(user, query);
    }

    public void addNewQuery(User user, Query query) {
        if (user == null || query == null) {
            throw new IllegalArgumentException("User or query cannot be null");
        }

        List<Query> userQueries = USER_QUERIES.computeIfAbsent(user, k -> new ArrayList<>());

        userQueries.add(query);
    }

    public void deleteUser(int id) {
        Iterator<Map.Entry<User, List<Query>>> iterator = USER_QUERIES.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<User, List<Query>> entry = iterator.next();
            User user = entry.getKey();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }

    public void printAllQueries() {

        for (Map.Entry<User, List<Query>> entry : USER_QUERIES.entrySet()) {
            User key = entry.getKey();
            List<Query> queryList = entry.getValue();

            for (Query query : queryList) {
                System.out.println("User: " + key.getName() +
                        ", with ID: " + key.getId() +
                        ", searched: " + query.getId() + ". \"" + query.getContent() +
                        "\", Date: " + query.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd MM:ss.SSSSSSSSS")));
            }
        }
    }
}
